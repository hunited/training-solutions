package covid;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CitizenDao {

    private static final String NAME_AND_PW = "covid";
    private final JdbcTemplate jdbcTemplate;

    public CitizenDao() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
            dataSource.setUser(NAME_AND_PW);
            dataSource.setPassword(NAME_AND_PW);
        } catch (SQLException se) {
            throw new IllegalStateException("Adatbázis kapcsolódás sikertelen!", se);
        }
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String validateName(String fullname) {
        if (fullname == null || fullname.trim().isEmpty()) {
            throw new IllegalArgumentException("A név nem lehet üres!");
        }
        return fullname.trim();
    }

    public String validateZip(String zipCode) {
        if (zipCode == null || zipCode.trim().length() != 4 || getSettlementsByZip(zipCode).isEmpty()) {
            throw new IllegalArgumentException("Irányítószám hiba: csak 4 karakter lehet, vagy nem található meg az adatbázisban!");
        }
        return zipCode.trim();
    }

    public int validateAge(int age) {
        if (age > 150 || age < 10) {
            throw new IllegalArgumentException("Az életkor csak 10 és 150 között lehet!");
        }
        return age;
    }

    public String validateEmail(String email) {
        if (email.trim().length() < 3 || !email.trim().contains("@")) {
            throw new IllegalArgumentException("E-mail formátum hiba: minimum 3 karakter és @ jel kötelező!");
        }
        return email.trim();
    }

    public String validateSSN(String ssn) {
        if (!validSsn(ssn.trim())) {
            throw new IllegalArgumentException("Nem érvényes a TAJ szám!");
        }
        return ssn.trim();
    }

    public List<String> getSettlementsByZip(String zipCode) {
        return jdbcTemplate.query("SELECT `settlement` FROM `cities` WHERE `zip` = ? ORDER BY `settlement`",
                (resultSet, i) -> resultSet.getString("settlement"), zipCode);
    }

    public boolean validSsn(String ssn) {
        if (ssn.length() != 9) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < ssn.length() - 1; i++) {
            int num = Character.getNumericValue(ssn.charAt(i));
            sum += i % 2 == 0 ? num * 3 : num * 7;
        }
        int cNumber = Character.getNumericValue(ssn.charAt(ssn.length() - 1));
        return sum % 10 == cNumber;
    }

    public String uploadCitizensFromFile(String fileName) {
        List<String> wrongLines = new ArrayList<>();
        int sum = 0;
        try (InputStream is = CitizenDao.class.getResourceAsStream(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String columns = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                sum = uploadCitizenFromFile(wrongLines, sum, line);
            }
            return getUploadResult(wrongLines, sum, columns);
        } catch (IOException ioe) {
            throw new IllegalStateException("Nincs fájl! ", ioe);
        } catch (NullPointerException npe) {
            throw new IllegalArgumentException("Fájl nem található! ", npe);
        }
    }

    public long uploadCitizenToDb(Citizen citizen) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO `citizens`(`citizen_name`, `zip`, `age`, `email`, `taj`) VALUES (?, ?, ?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, citizen.getFullName());
            statement.setString(2, citizen.getZipCode());
            statement.setInt(3, citizen.getAge());
            statement.setString(4, citizen.getEmail());
            statement.setString(5, citizen.getSsn());
            return statement;
        }, holder);
        return Objects.requireNonNull(holder.getKey()).longValue();
    }

    public String hasZipInCitizens(String zipCode) {
        List<String> result = jdbcTemplate.query("SELECT `zip` FROM `citizens` WHERE `zip` = ? LIMIT 1",
                (resultSet, i) -> resultSet.getString("zip"), zipCode);
        if (result.isEmpty()) {
            throw new IllegalArgumentException("Ezzel az irányítószámmal nincs paciens az adatbázisban!");
        }
        return zipCode;
    }

    public void saveListToFile(String zip, String fileName) {
        Path path = Path.of("src/main/resources/covid/" + fileName);
        try (Writer writer = new BufferedWriter(Files.newBufferedWriter(path))) {
            for (String row : listRowsByZip(zip)) {
                writer.write(row + "\n");
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Fájl nem található! ", ioe);
        }
    }

    private int uploadCitizenFromFile(List<String> wrongLines, int sum, String line) {
        try {
            String[] row = line.split(";");
            uploadCitizenToDb(new Citizen(row[0], row[1], Integer.parseInt(row[2]), row[3], row[4]));
            sum++;
        } catch (IllegalArgumentException iae) {
            wrongLines.add(line);
        }
        return sum;
    }

    private String getUploadResult(List<String> wrongLines, int sum, String columns) {
        if (wrongLines.isEmpty() && sum > 0) {
            return "Sikeresen feltöltve " + sum + " páciens (oszlopok: " + columns + ").";
        } else if (sum > 0) {
            StringBuilder sb = new StringBuilder("Néhány sor hibákat tartalmazott, a többi sikeresen feltöltve.\n")
                    .append("Ellenőrizze a lentieket, és töltse fel csak a hibás sorokat újra! A hibás sorok:\n");
            for (String wrongLine : wrongLines) {
                sb.append(wrongLine).append("\n");
            }
            return sb.toString();
        } else {
            throw new IllegalArgumentException("Hibás fájl: nem tartalmaz sorokat!");
        }
    }

    private List<String> listRowsByZip(String zip) {
        String query = """
                SELECT `citizen_name`, `zip`, `age`, `email`, `taj`
                FROM `citizens`
                WHERE `zip` = ? AND `number_of_vaccination` < 2 AND (
                    `last_vaccination` < (SELECT TIMESTAMP(DATE_SUB(NOW(), INTERVAL 15 DAY))) OR `last_vaccination` IS NULL
                )
                ORDER BY `age` DESC, `citizen_name` ASC LIMIT 16;""";
        List<String> result = jdbcTemplate.query(
                query, (resultSet, rowNumber) -> "datum" + ";" +
                        resultSet.getString("citizen_name") + ";" +
                        resultSet.getString("zip") + ";" +
                        resultSet.getInt("age") + ";" +
                        resultSet.getString("email") + ";" +
                        resultSet.getString("taj")
                , zip
        );
        return getTimeTable(result);
    }

    private List<String> getTimeTable(List<String> result) {
        LocalTime time = LocalTime.of(8, 0);
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i).replaceFirst("datum", time.toString()));
            time = time.plusMinutes(30);
        }
        result.add(0, "Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám");
        return result;
    }

}

package covid;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
            throw new IllegalStateException("Can not connect to database", se);
        }
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> getSettlementsByZip(String zipCode) {
        return jdbcTemplate.query("SELECT `settlement` FROM `postcodes` WHERE `zip` = ? ORDER BY `settlement`",
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
        int sum = 0;
        try (InputStream is = CitizenDao.class.getResourceAsStream(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String columns = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(";");
                Citizen citizen = new Citizen(row[0], row[1], Integer.parseInt(row[2]), row[3], row[4]);
                uploadCitizenToDb(citizen);
                sum++;
            }
            return "Successfully uploaded " + sum + " citizens (columns: " + columns + ").";
        } catch (IOException ioe) {
            throw new IllegalStateException("No file", ioe);
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

}

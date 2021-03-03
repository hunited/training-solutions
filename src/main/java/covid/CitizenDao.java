package covid;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    public List<String> getSettlementsByZip(String zipCode) {
        return jdbcTemplate.query("SELECT `settlement` FROM `cities` WHERE `zip` = ? ORDER BY `settlement`",
                (resultSet, i) -> resultSet.getString("settlement"), zipCode);
    }

    @Transactional
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

    public List<String> listRowsByZip(String zip) {
        LocalDateTime ldt = LocalDateTime.now().minusDays(15);
        String query = """
                SELECT `citizen_name`, `zip`, `age`, `email`, `taj`
                FROM `citizens`
                WHERE `zip` = ? AND `number_of_vaccination` < 2 AND (
                    `last_vaccination` < ? OR `last_vaccination` IS NULL
                )
                ORDER BY `age` DESC, `citizen_name` ASC LIMIT 16;""";
        List<String> result = jdbcTemplate.query(
                query, (resultSet, rowNumber) -> "datum" + ";" +
                        resultSet.getString("citizen_name") + ";" +
                        resultSet.getString("zip") + ";" +
                        resultSet.getInt("age") + ";" +
                        resultSet.getString("email") + ";" +
                        resultSet.getString("taj")
                , zip, ldt
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

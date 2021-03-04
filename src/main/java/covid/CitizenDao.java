package covid;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CitizenDao {

    private static final String NAME_AND_PW = "covid";
    private static final LocalDateTime MINUS_15_DAY = LocalDateTime.now().minusDays(15);
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

    public Integer hasSuitableTajInCitizens(String taj) {
        String query = """
                SELECT `citizen_id`, `number_of_vaccination`
                FROM `citizens`
                WHERE `taj` = ? AND `number_of_vaccination` < 2 AND (
                    `last_vaccination` < ? OR `last_vaccination` IS NULL
                ) LIMIT 1;""";
        List<Integer> result = jdbcTemplate.query(
                query, (resultSet, i) -> resultSet.getInt("citizen_id"), taj, MINUS_15_DAY
        );
        if (result.isEmpty()) {
            throw new IllegalArgumentException("Ezzel a TAJ számmal nincs paciens az adatbázisban, vagy jelenleg nem jogosult az oltásra!");
        }
        return result.iterator().next();
    }

    public VaccinationType firstVaccinationType(int citizenId) {
        List<VaccinationType> type = jdbcTemplate.query(
                "SELECT `vaccination_type` FROM `vaccinations` WHERE `citizen_id` = ? AND `status` = 'Sikeres' LIMIT 1;",
                (resultSet, i) -> VaccinationType.valueOf(resultSet.getString("vaccination_type")), citizenId
        );
        return type.isEmpty() ? null : type.get(0);
    }

    public List<String> listRowsByZip(String zip) {
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
                        resultSet.getString("taj"),
                zip, MINUS_15_DAY
        );
        return getTimeTable(result);
    }

    @Transactional
    public long successfulVaccination(int citizenId, LocalDateTime date, VaccinationType type) {
        updateCitizens(citizenId, date);
        return insertVaccinations(citizenId, date, type);
    }

    public long unsuccessfulVaccination(int citizenId, LocalDateTime date, String note) {
        String vaccinationsQuery = "INSERT INTO `vaccinations`(`citizen_id`, `vaccination_date`, `status`, `note`) VALUES (?, ?, ?, ?);";
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(vaccinationsQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, citizenId);
            statement.setTimestamp(2, Timestamp.valueOf(date));
            statement.setString(3, "Sikertelen");
            statement.setString(4, note);
            return statement;
        }, holder);
        return Objects.requireNonNull(holder.getKey()).longValue();
    }

    public List<String> queryZipCodes() {
        return jdbcTemplate.query(
                "SELECT `zip` FROM `citizens` WHERE 1 GROUP BY `zip` ORDER BY `zip`;",
                (resultSet, rowNumber) -> resultSet.getString("zip")
        );
    }

    public Map<Integer, Integer> queryNumberOfVaccinations(String zip) {
        String query = """
                SELECT `number_of_vaccination`, COUNT(`number_of_vaccination`) AS `piece`
                FROM `citizens`
                WHERE `zip` = ?
                GROUP BY `number_of_vaccination` ORDER BY `number_of_vaccination`;""";
        Map<Integer, Integer> result = new HashMap<>();
        jdbcTemplate.query(query, (resultSet, rowNumber) -> result.put(
                resultSet.getInt("number_of_vaccination"), resultSet.getInt("piece")), zip
        );
        return result;
    }

    private void updateCitizens(int citizenId, LocalDateTime date) {
        String citizensQuery = """
                UPDATE `citizens`
                SET `number_of_vaccination` = `number_of_vaccination` + 1, `last_vaccination`= ?
                WHERE `citizen_id` = ?;""";
        jdbcTemplate.update(citizensQuery, Timestamp.valueOf(date), citizenId);
    }

    private long insertVaccinations(int citizenId, LocalDateTime date, VaccinationType type) {
        String vaccinationsQuery = """
                INSERT INTO `vaccinations`(`citizen_id`, `vaccination_date`, `status`, `note`, `vaccination_type`)
                VALUES (?, ?, ?, ?, ?);""";
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(vaccinationsQuery, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, citizenId);
            statement.setTimestamp(2, Timestamp.valueOf(date));
            statement.setString(3, "Sikeres");
            statement.setString(4, "Az oltást a paciens elfogadta, annak beadása sikeresen megtörtént.");
            statement.setString(5, type.toString());
            return statement;
        }, holder);
        return Objects.requireNonNull(holder.getKey()).longValue();
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

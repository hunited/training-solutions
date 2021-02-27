package covid;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;

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

}

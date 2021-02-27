package covid;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class Config {

    private static final String NAME_AND_PW = "covid";
    private static MariaDbDataSource dataSource;

    @Bean
    public DataSource dataSource() {
        dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
            dataSource.setUser(NAME_AND_PW);
            dataSource.setPassword(NAME_AND_PW);
            return dataSource;
        } catch (SQLException se) {
            throw new IllegalStateException("Can not connect to database", se);
        }
    }

    @Bean
    public Flyway flyway() {
        return Flyway.configure().locations("filesystem:src/main/resources/covid").dataSource(dataSource).load();
    }

    @Bean
    public CitizenDao activityDaoSpring() {
        return new CitizenDao();
    }

}

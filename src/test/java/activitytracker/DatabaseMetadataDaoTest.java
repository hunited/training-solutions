package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseMetadataDaoTest {

    private static final String NAME_AND_PW = "employees";

    private DatabaseMetadataDao dao;

    @BeforeEach
    void setUp() {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser(NAME_AND_PW);
            dataSource.setPassword(NAME_AND_PW);
        } catch (SQLException se) {
            throw new IllegalStateException("Can not connect to database", se);
        }
        dao = new DatabaseMetadataDao(dataSource);
        Flyway flyway = Flyway.configure().locations("filesystem:src/main/resources/activitytracker").dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();
    }

    @Test
    void getTableNames() {
        List<String> result = dao.getColumnsForTable("activities");
        assertTrue(result.contains("activity_type"));
    }

}

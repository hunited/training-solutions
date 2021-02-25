package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = Config.class)
class DatabaseMetadataDaoSpringTest {

    @Autowired
    private Flyway flyway;

    @Autowired
    private DatabaseMetadataDaoSpring daoSpring;

    @BeforeEach
    void setUp() {
        flyway.clean();
        flyway.migrate();
    }

    @Test
    void getTableNames() {
        List<String> result = daoSpring.getColumnsForTable("activities");
        assertTrue(result.contains("activity_type"));
    }

}
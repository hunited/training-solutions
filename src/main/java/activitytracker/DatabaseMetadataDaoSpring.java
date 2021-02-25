package activitytracker;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseMetadataDaoSpring {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseMetadataDaoSpring(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> getColumnsForTable(String table) {
        String query = "SELECT * FROM " + table;
        return jdbcTemplate.query(query , rs -> {
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            List<String> result = new ArrayList<>();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                result.add(resultSetMetaData.getColumnName(i));
            }
            return result;
        });
    }

}

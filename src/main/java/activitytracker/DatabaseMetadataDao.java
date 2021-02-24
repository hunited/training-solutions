package activitytracker;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseMetadataDao {

    private final DataSource dataSource;

    public DatabaseMetadataDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getColumnsForTable(String table) {
        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            return getColumnNamesByMetaData(metaData, table);
        } catch (SQLException se) {
            throw new IllegalStateException("Can not read column names", se);
        }
    }

    private List<String> getColumnNamesByMetaData(DatabaseMetaData metaData, String table) throws SQLException {
        try (ResultSet resultSet = metaData.getColumns(null, null, table, null)) {
            List<String> names = new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString(4);
                names.add(name);
            }
            return names;
        }
    }

}

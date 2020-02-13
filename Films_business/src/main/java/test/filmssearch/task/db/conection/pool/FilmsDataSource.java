package test.filmssearch.task.db.conection.pool;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class FilmsDataSource {

    private static DataSource dataSource;

    private FilmsDataSource() {
    }

    public static void configure(ResourceBundle resourceBundle) throws ClassNotFoundException {
        Class.forName(resourceBundle.getString("db.driver.name"));
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(resourceBundle.getString("db.url"));
        hikariConfig.setUsername(resourceBundle.getString("db.username"));
        hikariConfig.setPassword(resourceBundle.getString("db.password"));

        hikariConfig.setMaximumPoolSize(20);
        hikariConfig.setMinimumIdle(5);
        dataSource = new HikariDataSource(hikariConfig);
    }

    public static Connection getConnection() throws SQLException {
        check();
        return dataSource.getConnection();
    }

    public static DataSource getDataSource() throws SQLException {
        check();
        return dataSource;
    }

    private static void check() throws SQLException {
        if (dataSource == null) {
            throw new SQLException("DataSourse empty");
        }
    }
}

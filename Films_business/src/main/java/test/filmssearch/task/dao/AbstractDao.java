package test.filmssearch.task.dao;

import org.slf4j.Logger;
import test.filmssearch.task.db.conection.pool.FilmsDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDao {
    protected final Logger logger;

    protected AbstractDao(Logger logger) {
        this.logger = logger;
    }

    protected Connection getConnection() throws SQLException {
        return FilmsDataSource.getConnection();
    }

    protected void closeQuietly(AutoCloseable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (Exception e) {
            logger.error("Error while closing closable: " + closeable, e);
        }
    }
}
package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.filmssearch.task.db.conection.pool.FilmsDataSource;
import test.filmssearch.task.db.migration.FilmsMigration;

import java.sql.SQLException;
import java.util.ResourceBundle;

@WebListener
public class Listener implements ServletContextListener {
    private static final Logger logger = LoggerFactory.getLogger(Listener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            logger.info("===Context initialized===");
            ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
            FilmsDataSource.configure(resourceBundle);
            DataSource dataSource = FilmsDataSource.getDataSource();
            FilmsMigration.migration(dataSource);
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("ERROR666", e);
            throw new RuntimeException("Datasource initialisation error", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("Context destroyed");
    }
}


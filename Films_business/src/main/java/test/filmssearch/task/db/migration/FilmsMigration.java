package test.filmssearch.task.db.migration;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

public final class FilmsMigration {
    public static final Logger logger = LoggerFactory.getLogger(FilmsMigration.class);

    private FilmsMigration() {
    }

    public static void migration(DataSource dataSource) {
        logger.info("Start Migration");
        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.migrate();
        logger.info("End Migration");
    }

}

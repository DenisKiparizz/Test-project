package test.filmssearch.task.dao;

import test.filmssearch.task.entity.Director;

import java.sql.SQLException;
import java.util.List;

public interface DirectorDAO {
    List<Director> getAllDirectors() throws SQLException;
}

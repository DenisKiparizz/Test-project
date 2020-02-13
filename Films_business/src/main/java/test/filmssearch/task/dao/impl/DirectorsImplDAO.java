package test.filmssearch.task.dao.impl;


import org.slf4j.LoggerFactory;
import test.filmssearch.task.dao.AbstractDao;
import test.filmssearch.task.dao.DirectorDAO;
import test.filmssearch.task.entity.Director;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirectorsImplDAO extends AbstractDao implements DirectorDAO {

    protected DirectorsImplDAO() {
        super(LoggerFactory.getLogger(DirectorsImplDAO.class));
    }

    private static DirectorsImplDAO INSTANCE = new DirectorsImplDAO();

    public static DirectorsImplDAO getInstance() {
        return INSTANCE;
    }
    private static final String GET_ALL_DIRECTORS = "select id,last_name from director;";

    @Override
    public List<Director> getAllDirectors() throws SQLException {
        List<Director> reliseDates = new ArrayList<>();
        ResultSet resultset = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_DIRECTORS)) {
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                reliseDates.add(mappingDirector(resultset));
            }
        } finally {
            closeQuietly(resultset);
        }
        return reliseDates;
    }

    private Director mappingDirector(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String last_name = resultSet.getString("last_name");
        return new Director(id, last_name);
    }
}

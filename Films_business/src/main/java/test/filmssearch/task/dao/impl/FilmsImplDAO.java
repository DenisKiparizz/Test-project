package test.filmssearch.task.dao.impl;


import org.slf4j.LoggerFactory;
import test.filmssearch.task.dao.AbstractDao;
import test.filmssearch.task.dao.FilmDAO;
import test.filmssearch.task.entity.Director;
import test.filmssearch.task.entity.Films;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmsImplDAO extends AbstractDao implements FilmDAO {
    protected FilmsImplDAO() {
        super(LoggerFactory.getLogger(FilmsImplDAO.class));
    }

    private static FilmsImplDAO INSTANCE = new FilmsImplDAO();

    public static FilmsImplDAO getInstance() {
        return INSTANCE;
    }

    private static final String GET_BY_DATE = "select f.*, d.first_name,d.last_name,d.birth_day from director d  join film f on d.id = f.director_id where f.release_date between ? and ? order by release_date;";
    private static final String GET_BY_START_DATE_AND_DIRECTOR = "select f.*, d.first_name,d.last_name,d.birth_day from director d  join film f on d.id = f.director_id where d.id=? and  f.release_date > ? order by release_date;";
    private static final String GET_BY_START_DATE = "select f.*, d.first_name,d.last_name,d.birth_day from director d  join film f on d.id = f.director_id where f.release_date > ? order by release_date;";
    private static final String GET_BY_DIRECTOR_ID = "select f.*, d.first_name,d.last_name,d.birth_day from director d  join film f on d.id = f.director_id where director_id = ? order by id;";
    private static final String GET_BY_DIRECTOR_ID_AND_DATES = "select f.*, d.first_name,d.last_name,d.birth_day from director d  join film f on d.id = f.director_id where  f.director_id  = ? and f.release_date between ? and ? order by id;";
    @Override
    public List<Films> findByDirectorId(Long id) throws SQLException {
        List<Films> filmList = new ArrayList<>();
        ResultSet resultset = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DIRECTOR_ID)) {
            preparedStatement.setLong(1, id);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                filmList.add(mappingFilms(resultset));
            }
        } finally {
            closeQuietly(resultset);
        }
        return filmList;
    }

    @Override
    public List<Films> findByDirectorIdAndFilmRealiseDate(Long id, Long date1, Long date2) throws SQLException {
        List<Films> filmList = new ArrayList<>();
        ResultSet resultset = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DIRECTOR_ID_AND_DATES)) {
            preparedStatement.setLong(1, id);
            preparedStatement.setLong(2, date1);
            preparedStatement.setLong(3, date2);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                filmList.add(mappingFilms(resultset));
            }
        } finally {
            closeQuietly(resultset);
        }
        return filmList;
    }

    @Override
    public List<Films> findByRealiseDates(Long date1, Long date2) throws SQLException {
        List<Films> filmList = new ArrayList<>();
        ResultSet resultset = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_DATE)) {
            preparedStatement.setLong(1, date1);
            preparedStatement.setLong(2, date2);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                filmList.add(mappingFilms(resultset));
            }
        } finally {
            closeQuietly(resultset);
        }
        return filmList;
    }

    @Override
    public List<Films> findByDirectorIdAndOneFilmRealiseDate(Long id, Long date1) throws SQLException {
        List<Films> filmList = new ArrayList<>();
        ResultSet resultset = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_START_DATE_AND_DIRECTOR)) {
            preparedStatement.setLong(1, id);
            preparedStatement.setLong(2, date1);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                filmList.add(mappingFilms(resultset));
            }
        } finally {
            closeQuietly(resultset);
        }
        return filmList;
    }

    @Override
    public List<Films> findByRealiseOneDate(Long date1) throws SQLException {
        List<Films> filmList = new ArrayList<>();
        ResultSet resultset = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_START_DATE)) {
            preparedStatement.setLong(1, date1);
            resultset = preparedStatement.executeQuery();
            while (resultset.next()) {
                filmList.add(mappingFilms(resultset));
            }
        } finally {
            closeQuietly(resultset);
        }
        return filmList;
    }
    private Films mappingFilms(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        Director director = new Director(resultSet.getLong("id"), resultSet.getString("first_name"),
                resultSet.getString("last_name"), resultSet.getDate("birth_day"));
        String name = resultSet.getString("name");
        Integer releaseDate = resultSet.getInt("release_date");
        String genre = resultSet.getString("genre");
        return new Films(id, director, name, releaseDate, genre);
    }
}

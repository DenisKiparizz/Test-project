package test.filmssearch.task.dao;


import test.filmssearch.task.entity.Films;

import java.sql.SQLException;
import java.util.List;

public interface FilmDAO {

    List<Films> findByDirectorId(Long id) throws SQLException;


    List<Films> findByDirectorIdAndFilmRealiseDate(Long id, Long date1, Long date2) throws SQLException;

    List<Films> findByRealiseDates(Long date1, Long date2) throws SQLException;


    List<Films> findByDirectorIdAndOneFilmRealiseDate(Long id, Long date1) throws SQLException;

    List<Films> findByRealiseOneDate(Long date1) throws SQLException;

}

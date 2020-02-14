package test.filmssearch.task.service;


import test.filmssearch.task.entity.Films;

import java.sql.SQLException;
import java.util.List;

public interface FilmServiceInterface {
    List<Films> findByDirectorId(Long id);


    List<Films> findByRealiseDates(Long date1, Long date2);

    List<Films> findByDirectorIdAndOneFilmRealiseDate(Long id, Long date1);

    List<Films> findByRealiseOneDate(Long date1);

    List<Films> findByDirectorIdAndFilmRealiseDate(Long id, Long date1, Long date2);
    //

    List<Films> isParametersIsNull(String id, String date);

    List<Films> isParametersIsNullWithTwoDates(String idStr, String d1, String d2);




}

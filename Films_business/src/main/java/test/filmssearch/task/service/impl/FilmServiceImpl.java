package test.filmssearch.task.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.filmssearch.task.dao.FilmDAO;
import test.filmssearch.task.dao.impl.FilmsImplDAO;
import test.filmssearch.task.entity.Films;
import test.filmssearch.task.service.FilmServiceInterface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmServiceImpl implements FilmServiceInterface {
    private static final Logger logger = LoggerFactory.getLogger(FilmServiceImpl.class);
    private static FilmServiceImpl INSTANCE = new FilmServiceImpl();
    private static final FilmDAO instDao = FilmsImplDAO.getInstance();

    public static FilmServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Films> findByDirectorId(Long id) {
        List<Films> list = new ArrayList<>();
        try {
            list = instDao.findByDirectorId(id);
        } catch (SQLException e) {
            logger.error("===Find by Director ID===");
        }
        return list;
    }


    @Override
    public List<Films> findByRealiseDates(Long date1, Long date2) {
        List<Films> list = new ArrayList<>();
        try {
            list = instDao.findByRealiseDates(date1, date2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Films> findByDirectorIdAndOneFilmRealiseDate(Long id, Long date1) {
        List<Films> list = new ArrayList<>();
        try {
            list = instDao.findByDirectorIdAndOneFilmRealiseDate(id, date1);
        } catch (SQLException e) {
            logger.error("===Find by Realise Date and Director ID===");
        }
        return list;
    }

    @Override
    public List<Films> findByRealiseOneDate(Long date1) {
        List<Films> list = new ArrayList<>();
        try {
            list = instDao.findByRealiseOneDate(date1);
        } catch (SQLException e) {
            logger.error("===Find By Realise Date===");
        }
        return list;
    }

    @Override
    public List<Films> isParametersIsNull(String idStr, String date) {
        try {
            if (idStr == null || idStr.length() == 0) {
                Long date1 = Long.valueOf(date);
                return getInstance().findByRealiseOneDate(date1);
            } else if (date == null || date.length() == 0) {
                Long id = Long.valueOf(idStr);
                return getInstance().findByDirectorId(id);
            } else {
                Long date1 = Long.valueOf(date);
                Long id = Long.valueOf(idStr);
                return getInstance().findByDirectorIdAndOneFilmRealiseDate(id, date1);
            }
        } catch (NumberFormatException e) {
            logger.error("===Wrong Logic Method in FilmServiceImpl===");
        }
        return null;
    }

    @Override
    public List<Films> findByDirectorIdAndFilmRealiseDate(Long id, Long date1, Long date2) {
        List<Films> list = new ArrayList<>();
        try {
            list = instDao.findByDirectorIdAndFilmRealiseDate(id, date1, date2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Films> isParametersIsNullWithTwoDates(String idStr, String d1, String d2) {
        try {
            if (idStr == null || idStr.length() == 0) {
                Long date1 = Long.valueOf(d1);
                Long date2 = Long.valueOf(d2);
                return getInstance().findByRealiseDates(date1, date2);
            } if (d1 == null || d1.length() == 0 && d2 == null || d2.length() == 0) {
                Long id = Long.valueOf(idStr);
                return getInstance().findByDirectorId(id);
            } else {
                Long id = Long.valueOf(idStr);
                Long date1 = Long.valueOf(d1);
                Long date2 = Long.valueOf(d2);
                return getInstance().findByDirectorIdAndFilmRealiseDate(id, date1, date2);
            }
        } catch (NumberFormatException e) {
            logger.error("===Wrong Logic Method in FilmServiceImpl===");
        }
        return null;
    }
}


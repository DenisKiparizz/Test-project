package test.filmssearch.task.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.filmssearch.task.dao.DirectorDAO;
import test.filmssearch.task.dao.impl.DirectorsImplDAO;
import test.filmssearch.task.entity.Director;
import test.filmssearch.task.service.DirectorServiceInterface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirectorServiceIImpl implements DirectorServiceInterface {
    private static DirectorDAO directorDAO = DirectorsImplDAO.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(DirectorServiceIImpl.class);
    private static final DirectorServiceIImpl INSTANCE = new DirectorServiceIImpl();

    public static DirectorServiceIImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Director> getAllDirectors() {
        List<Director> list = new ArrayList<>();
        try {
            list = directorDAO.getAllDirectors();
        } catch (SQLException e) {
            logger.error("====Error From GETALLDIRECTORS====");
        }
        return list;
    }
}


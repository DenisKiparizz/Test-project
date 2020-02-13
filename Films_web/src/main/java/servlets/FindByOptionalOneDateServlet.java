package servlets;

import test.filmssearch.task.entity.Director;
import test.filmssearch.task.entity.Films;
import test.filmssearch.task.service.DirectorServiceInterface;
import test.filmssearch.task.service.FilmServiceInterface;
import test.filmssearch.task.service.impl.DirectorServiceIImpl;
import test.filmssearch.task.service.impl.FilmServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/allOptionalWithOneDate")
public class FindByOptionalOneDateServlet extends HttpServlet {
    private static FilmServiceInterface instance = FilmServiceImpl.getInstance();
    private static DirectorServiceInterface instanceDir = DirectorServiceIImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Director> listDirectors = instanceDir.getAllDirectors();
        req.setAttribute("list", listDirectors);
        req.getRequestDispatcher("WEB-INF/jsp/find_by_one_all_select.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        String d1 = req.getParameter("date1");
        List<Films> list = instance.isParametersIsNull(idStr, d1);
        if (list == null) {
            req.getRequestDispatcher("WEB-INF/jsp/null_list.jsp").forward(req, resp);
        } else
            req.setAttribute("listFilm", list);
        req.getRequestDispatcher("WEB-INF/jsp/get_result_by_date_and_id.jsp").forward(req, resp);
    }
}
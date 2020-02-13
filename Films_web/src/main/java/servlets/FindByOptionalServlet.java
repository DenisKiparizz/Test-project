package servlets;
import test.filmssearch.task.entity.Films;
import test.filmssearch.task.service.FilmServiceInterface;
import test.filmssearch.task.service.impl.FilmServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/allOptional")
public class FindByOptionalServlet extends HttpServlet {
    private static FilmServiceInterface instance = FilmServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/find_by_all_select.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        String d1 = req.getParameter("date1");
        String d2 = req.getParameter("date2");
        List<Films> list = instance.isParametersIsNullWithTwoDates(idStr, d1, d2);
        req.setAttribute("listFilm", list);
        req.getRequestDispatcher("WEB-INF/jsp/get_result_by_date_and_id.jsp").forward(req, resp);
    }
}

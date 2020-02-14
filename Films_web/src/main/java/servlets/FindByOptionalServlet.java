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
        boolean error = false;
        String errorMessage = "";
        if (isaConditionalToFullEveryColumn(idStr, d1, d2)) {
            error = true;
            errorMessage = fullEveryColumnMessage();
        } else if (isaConditionForUseOnlyTwoDates(idStr, d1, d2)) {
            error = true;
            errorMessage = fullTwoDatesMessage();
        } else {
            List<Films> list = instance.isParametersIsNullWithTwoDates(idStr, d1, d2);
            req.setAttribute("listFilm", list);
            if (list.isEmpty()){
                req.getRequestDispatcher("WEB-INF/jsp/null_list.jsp").forward(req, resp);
            }
        }
        if (error) {
            req.setAttribute("ERROR", errorMessage);
            req.getRequestDispatcher("WEB-INF/jsp/find_by_all_select.jsp").forward(req, resp);
        }
        req.getRequestDispatcher("WEB-INF/jsp/get_result_by_date_and_id.jsp").forward(req, resp);
    }


    private String fullTwoDatesMessage() {
        return "You have to use particular time interval in this case.\nPlease select time interval.";
    }

    private String fullEveryColumnMessage() {
        return "In this case you have to full \n1.Every field\n2.Two dates field\n3.Only director ID";
    }

    private boolean isaConditionalToFullEveryColumn(String idStr, String d1, String d2) {
        return (d1.isEmpty() || d2.isEmpty()) && (idStr.isEmpty());
    }

    private boolean isaConditionForUseOnlyTwoDates(String idStr, String d1, String d2) {
        return (!(d1.isEmpty() || idStr.isEmpty()) && (d2.isEmpty())) || (!(d2.isEmpty() || idStr.isEmpty()) && (d1.isEmpty()));
    }
}


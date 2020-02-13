package servlets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class HomePageServletTest extends Mockito {
    private final static String path = "WEB-INF/jsp/home_page.jsp";
    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    RequestDispatcher dispatcher;
    private HomePageServlet homePageServlet = new HomePageServlet();

    @Test
    public void shouldGetToParticularJSP() throws ServletException, IOException {
        when(request.getRequestDispatcher(path)).thenReturn(dispatcher);
        homePageServlet.doGet(request, response);
        verify(dispatcher).forward(request, response);
    }
}

package impl.com.bjpn.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author futao
 * Created on 2017/12/28 - 22:13.
 */
@WebServlet(name = "ForwardServlet", urlPatterns = "/forward")
public class ForwardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("disPath");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/print");

        /*请求转发*/
        requestDispatcher.forward(request, response);

//        requestDispatcher.include(request, response);

    }
}

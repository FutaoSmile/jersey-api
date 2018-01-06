package impl.com.bjpn.servlet;

import kotlin.jvm.Throws;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author futao
 * Created on 2017/12/28 - 21:40.
 */
@WebServlet(name = "PrintServlet", urlPatterns = "/print")
public class PrintServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*设置相应的MIME类型;其中可以指定MIME的字符编码，即响应的字符编码*/
        response.setContentType("text/html;charset=UTF-8");
        /*必须放在writer之前,其实修改的MIME的字符编码;即可以省略setContentType中的charset*/
        //response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        /*向标准输出流中输出数据*/
        writer.append("Niubi");
        writer.println("6666666666666");
        writer.write("7777777777777777");
        writer.write("7777777777777777");
        writer.println("username:"+request.getParameter("username"));
        writer.println("username:"+request.getParameter("password"));


//        response销毁的时候服务器会帮我们自动关闭IO流，所以不必手动关闭
//        writer.close();
    }
}

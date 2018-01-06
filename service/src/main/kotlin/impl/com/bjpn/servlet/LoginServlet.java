package impl.com.bjpn.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author futao
 * Created on 2017/12/25 - 20:16.
 */
public class LoginServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("running....");
        /**
         * 获取请求的提交方式method
         */
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        if ("GET".equals(httpServletRequest.getMethod())){
              System.out.println("the method is GET");
        }
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        System.out.println("the method is...." + httpServletRequest.getMethod());
    }
}

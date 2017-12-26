package impl.com.bjpn.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author futao
 * Created on 2017/12/24 - 18:41.
 * <p>
 * 1.servlet是单例的
 * 2.并且可以同时被很多浏览器和用户访问，所以是多线程了
 */
public class SomeServlet implements Servlet {
    private ServletConfig servletConfig;
    public SomeServlet() {
        /*Servlet生命周期方法001  只会执行一次，    单例*/
        System.out.println("构造方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        /*Servlet生命周期方法002只会执行一次     当第一次请求到达的时候执行的，而不是容器被创建的时间。如果要在容器创建的时候自动初始化这个实例那么需要在xml文件中进行配置load-on-startup*/
        System.out.println("init方法");
        this.servletConfig=servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println(servletRequest.getContentType());
        System.out.println(servletRequest.getLocalAddr());
        System.out.println(servletRequest.getLocalPort());
        System.out.println(servletRequest.getServerPort());
        /*003 n次，每次响应都是一次*/
        System.out.println("service方法");
        /*Servlet名字*/
        System.out.println(servletConfig.getServletName());
        /*ServletContext，一个应用就一个ServletContext对象，所有的servlet的上下文环都是一样的
        servletContext就是ApplicationContext*/
        System.out.println(servletConfig.getServletContext());
        /*init-parameter 配置数据*/
        System.out.println(servletConfig.getInitParameter("author"));
        System.out.println(servletConfig.getInitParameter("address"));
        /*枚举*/
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String nextElement = initParameterNames.nextElement();
            System.out.println("parameterName:" +nextElement);
            System.out.println("value:" +servletConfig.getInitParameter(nextElement));
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet 的版本；Servlet的作者；servlet所在应用等基本关于该servlet的信息";
    }

    @Override
    public void destroy() {
        /*Servlet生命周期方法004  只服务器停止的时候会执行该方法*/
        System.out.println("destroy方法");
    }
}

package filter;

import annotation.LoginUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * @author futao
 * Created on 2017/12/26 - 20:44.
 */

@LoginUser
@Provider
public class LoginUserRequestFilter implements ContainerRequestFilter {
    @Context
    private HttpServletRequest request;

    @Context
    private HttpServletResponse response;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        System.out.println("已登录用户");
    }
}

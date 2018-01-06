package filter

import javax.servlet.*

/**
 * @author futao
 * Created on 2017/12/26 - 21:31.
 */
class AppFilter : Filter{
    override fun destroy() {

    }

    override fun doFilter(  servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain) {
            servletResponse.characterEncoding = Charsets.UTF_8.name()
        filterChain.doFilter(servletRequest, servletResponse)
    }

    @Throws(ServletException::class)
    override fun init(p0: FilterConfig?) {

    }

}
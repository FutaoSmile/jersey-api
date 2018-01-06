//package filter
//
//import annotation.LoginUser
//import javax.ws.rs.container.ContainerRequestContext
//import javax.ws.rs.container.ContainerRequestFilter
//import javax.ws.rs.ext.Provider
//
///**
// * @author futao
// * Created on 2017/12/22 - 21:17.
// */
//@LoginUser
//@Provider
//open class LoginUserRequestFilter : ContainerRequestFilter {
//
////    @Context
////    private val request: HttpServletRequest? = null
////
////    @Context
////    private val response: HttpServletResponse? = null
//
//    override fun filter(p0: ContainerRequestContext?) {
//        println("================================登陆了")
//    }
//
//}
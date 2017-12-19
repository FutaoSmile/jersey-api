package impl.service

import face.service.UserService
import app.bean
import face.dao.UserDao
import org.hibernate.SessionFactory

/**
 * @author futao
 * Created on 2017/12/19 - 16:52.
 * 这个文件用于获取Service和dao层的bean
 * 因为用kotlin代码实现依赖注入并不友好
 *
 * eg:
 *  @Resource
 *  var userService: UserService? = null
 */
val userService = bean(UserService::class.java)
val userDao = bean(UserDao::class.java)

/*获取sessionFactory*/
val sessionFactory: SessionFactory = bean("sessionFactory")

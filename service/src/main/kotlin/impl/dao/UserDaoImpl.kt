package impl.dao


import app.hibernate.currentSession
import entity.User
import face.dao.UserDao
import org.hibernate.criterion.Restrictions
import org.springframework.stereotype.Repository

/**
 * @author futao
 * Created on 2017/12/19 - 17:18.
 */
@Repository
open class UserDaoImpl : UserDao {
    override fun list(nickname: String, mobile: String): List<User> {
        val criteria = currentSession().createCriteria(User::class.java)
        if (!nickname.isNullOrBlank()) {
            criteria.add(Restrictions.like(User._nickName, nickname))
        }
        if (!mobile.isNullOrBlank()) {
            criteria.add(Restrictions.like(User._mobile, mobile))
        }
        return criteria.list() as List<User>
    }
}

package impl.service

import entity.User
import face.service.UserService
import org.hibernate.cfg.Configuration
import org.joda.time.DateTime
import org.springframework.stereotype.Service
import java.sql.Timestamp

/**
 * @author futao
 * Created on 2017/12/19 - 13:14.
 */
@Service
open class UserServiceImpl : UserService {
    override fun add(nickName: String, mobile: String): User {
        val configuration = Configuration().configure()
        val buildSessionFactory = configuration.buildSessionFactory()
        val openSession = buildSessionFactory.openSession()
        val beginTransaction = openSession.beginTransaction()

        val user = User().apply {
            setMobile("123456789")
            setNickName("nickname")
            createTime = Timestamp(DateTime.now().millis)
            lastModifyTime = Timestamp(DateTime.now().millis)
        }
        openSession.save(user)
        beginTransaction.commit()
        openSession.close()
        buildSessionFactory.close()
        return user
    }

}
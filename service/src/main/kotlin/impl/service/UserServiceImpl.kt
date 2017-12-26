package impl.service

import app.TransactionTimeout
import entity.User
import utils.service.save
import face.service.UserService
import org.joda.time.DateTime
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Transactional
import java.sql.Timestamp

/**
 * @author futao
 * Created on 2017/12/19 - 13:14.
 */
@Service
@Transactional(timeout = TransactionTimeout, isolation = Isolation.REPEATABLE_READ)
open class UserServiceImpl : UserService {
    override fun add(nickName: String, mobile: String): User {
        return User().apply {
            setMobile(nickName)
            setNickName(mobile)
            createTime = Timestamp(DateTime.now().millis)
            lastModifyTime = Timestamp(DateTime.now().millis)
        }
                .save()
    }

    override fun list(nickName: String, mobile: String): List<User> {
        return userDao.list(mobile, mobile)
    }

}
package impl.chain

import entity.User
import face.chain.UserChain
import impl.service.userService
import org.springframework.stereotype.Component

/**
 * @author futao
 * Created on 2017/12/19 - 13:23.
 */
@Component
open class UserChainImpl : UserChain {

    override fun add(nickName: String, mobile: String): User? {
        return userService.add(nickName, mobile)
    }

    override fun list(nickname: String, mobile: String): List<User> {
        return userService.list(mobile, mobile)
    }
}
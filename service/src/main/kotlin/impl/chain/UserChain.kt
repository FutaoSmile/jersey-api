package impl.chain

import entity.User
import face.chain.UserChain
import face.service.UserService
import org.springframework.stereotype.Service
import javax.annotation.Resource

/**
 * @author futao
 * Created on 2017/12/19 - 13:23.
 */
@Service
open class UserChainImpl : UserChain {
    @Resource
    var userService: UserService? = null

    override fun add(nickName: String, mobile: String): User? {
        return userService?.add(nickName, mobile)
    }

}
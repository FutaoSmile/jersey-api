package impl.chain

import entity.User
import face.chain.UserChain
import impl.controller.Niu
import impl.service.userService
import org.springframework.stereotype.Service

/**
 * @author futao
 * Created on 2017/12/19 - 13:23.
 */
@Service
open class UserChainImpl : UserChain {

    override fun add(nickName: String, mobile: String): User? {
        return userService.add(nickName, mobile)
    }

    override fun list(nickname: String, mobile: String): Niu {
        return Niu().apply {
            list= userService.list(mobile, mobile)
        }
    }
}
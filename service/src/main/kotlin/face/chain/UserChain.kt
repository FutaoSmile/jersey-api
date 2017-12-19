package face.chain

import entity.User

/**
 * @author futao
 * Created on 2017/12/19 - 13:23.
 */
interface UserChain {
    fun add(nickName: String, mobile: String): User?
    fun list(nickname: String, mobile: String): List<User>
}
package face.service

import entity.User

/**
 * @author futao
 * Created on 2017/12/19 - 13:14.
 */
interface UserService {
    fun add(nickName: String, mobile: String): User
}
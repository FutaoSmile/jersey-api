package face.dao

import entity.User

interface UserDao {

    fun list(nickname: String, mobile: String): List<User>
}
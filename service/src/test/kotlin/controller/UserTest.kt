package controller

import com.google.gson.GsonBuilder
import entity.User
import org.junit.Test

/**
 * @author futao
 * Created on 2017/12/19 - 16:19.
 */
class UserTest {
    @Test
    fun add() {
        val user = User().apply {
            mobile = "12312312"
            nickName = "fsdfdf"
        }
        println(GsonBuilder().serializeNulls().setPrettyPrinting().create().toJson(user))

    }
}
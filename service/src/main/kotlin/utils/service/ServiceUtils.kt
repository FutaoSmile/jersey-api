package utils.service

import entity.base.TimeEntity
import impl.service.sessionFactory
import org.hibernate.Session
import org.joda.time.DateTime
import java.io.Serializable
import java.sql.Timestamp

/**
 * @author futao
 * Created on 2017/12/19 - 17:23.
 */
var session: Session? = null

fun currentSession(): Session {
    return if (session == null) {
        sessionFactory.currentSession
    } else {
        session as Session
    }
}

/**
 * 保存实体
 */
fun <T> T.save(): T {
    currentSession().save(this)
    return this
}

/**
 * 删除
 */
fun <T> T.delete(): T {
    currentSession().delete(this)
    return this
}

/**
 * get，自动类型转换
 */
fun <T> Class<T>.get(id: Serializable): T? {
    return if (id is String && id.isBlank()) null
    else currentSession().get(this, id) as T
}


fun <T : TimeEntity> T.setCreateLastModifyTimeNow(): T {
    val now = Timestamp(DateTime.now().millis)
    this.createTime = now
    this.lastModifyTime = now
    return this
}
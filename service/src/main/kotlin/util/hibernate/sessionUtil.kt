package app.hibernate

import impl.service.sessionFactory
import org.hibernate.Session

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
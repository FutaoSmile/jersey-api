package app

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Service

/**
 * @author futao
 * Created on 2017/12/19 - 16:59.
 */
@Service
class SpringContextUtil : ApplicationContextAware {
    override fun setApplicationContext(p0: ApplicationContext?) {
        applicationContext = p0
    }

    companion object {
        private var applicationContext: ApplicationContext? = null
        fun context(): ApplicationContext? {
            if (applicationContext == null) {
                throw NullPointerException("applicationContext is null")
            } else {
                return applicationContext
            }
        }
    }

}
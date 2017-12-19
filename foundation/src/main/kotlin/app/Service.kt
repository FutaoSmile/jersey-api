package app

import org.springframework.context.ApplicationContext

/**
 * @author futao
 * Created on 2017/12/19 - 16:56.
 */
var applicationContext: ApplicationContext? = null

fun context(): ApplicationContext {
    if (applicationContext == null) {
        applicationContext = SpringContextUtil.context()
    }
    return applicationContext as ApplicationContext
}


fun <T> bean(name: String): T {
    return context().getBean(name) as T
}

fun <T> bean(name: Class<T>): T {
    return context().getBean(name) as T
}
package app

import org.glassfish.jersey.media.multipart.MultiPartFeature
import org.glassfish.jersey.server.ResourceConfig

/**
 * @author futao
 * Created on 2017/12/19 - 14:49.
 */
open class RestJaxRsApplication : ResourceConfig() {
    init {
        register(MultiPartFeature::class.java)
    }
}
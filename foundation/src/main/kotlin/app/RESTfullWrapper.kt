package app

import com.google.gson.GsonBuilder
import entity.base.RESTfullAPI
import java.io.OutputStream
import java.lang.reflect.Type
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.MultivaluedMap
import javax.ws.rs.ext.MessageBodyWriter

/**
 * @author futao
 * Created on 2017/12/22 - 21:39.
 * 把返回的数据包装成RESTfull API
 */
class RESTfullWrapper : MessageBodyWriter<RESTfullAPI> {
    override fun getSize(p0: RESTfullAPI?, p1: Class<*>?, p2: Type?, p3: Array<out Annotation>?, p4: MediaType?): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return -1
    }

    override fun writeTo(p0: RESTfullAPI?, p1: Class<*>?, p2: Type?, p3: Array<out Annotation>?, p4: MediaType?, p5: MultivaluedMap<String, Any>?, p6: OutputStream?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val result= GsonBuilder().serializeNulls().setPrettyPrinting().create().toJson(p0)
        println("===========")
        p6?.write(result.toByteArray())
    }

    override fun isWriteable(p0: Class<*>?, p1: Type?, p2: Array<out Annotation>?, p3: MediaType?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return true
    }
}
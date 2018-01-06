package app

import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import com.google.gson.GsonBuilder
import entity.base.RESTfullAPI
import java.io.IOException
import java.io.OutputStream
import java.lang.reflect.Type
import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.MultivaluedMap
import javax.ws.rs.ext.MessageBodyWriter

/**
 * @author futao
 * Created on 2017/12/22 - 21:39.
 * 把返回的数据包装成REST full API
 */
class RESTfullWrapper : MessageBodyWriter<RESTfullAPI> {
    override fun getSize(p0: RESTfullAPI?, p1: Class<*>?, p2: Type?, p3: Array<out Annotation>?, p4: MediaType?): Long {
        return -1
    }
    @Throws(IOException::class, WebApplicationException::class)
    override fun writeTo(p0: RESTfullAPI?, p1: Class<*>?, p2: Type?, p3: Array<out Annotation>?, p4: MediaType?, p5: MultivaluedMap<String, Any>?, p6: OutputStream?) {
//        val result= GsonBuilder().serializeNulls().setPrettyPrinting().create().toJson(p0)
//        println("===========")
//        p6?.write(result.toByteArray())

        val result = RestResult()
        result.code = "0"
        result.result = p0
        val s = GsonBuilder().setExclusionStrategies(STRATEGY).serializeNulls().setPrettyPrinting().create().toJson(result)
        println(s)
        p6?.write(s.toByteArray())
    }

    override fun isWriteable(p0: Class<*>?, p1: Type?, p2: Array<out Annotation>?, p3: MediaType?): Boolean {
        return true
    }
}

class RestResult {
    var code = "0"
    var msg:String? = null
    //    var type = ""
    var result: Any? = null
}


val STRATEGY = GsonSkipExclusionStrategy()

class GsonSkipExclusionStrategy : ExclusionStrategy {

    override fun shouldSkipField(fieldAttributes: FieldAttributes): Boolean {
//        return null != fieldAttributes.getAnnotation(GsonSkip::class.java)
        return false
    }

    override fun shouldSkipClass(aClass: Class<*>): Boolean {
        return false
    }
}

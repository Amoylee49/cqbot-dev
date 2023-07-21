package org.bot.dev.utils

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.text.SimpleDateFormat

object JsonUtils {
    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    //        @JvmField
    private val OBJECT_MAPPER = ObjectMapper()

    init {
        //序列化的时候序列对象的所有属性
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        //序列化的时候序列对象的所有属性
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        //反序列化的时候如果多了其他属性,不抛出异常
        OBJECT_MAPPER.configure(
            DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
            false
        )

        //如果是空对象的时候,不抛异常
        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
        //取消时间的转化格式,默认是时间戳,可以取消,同时需要设置要表现的时间格式
        OBJECT_MAPPER.configure(
            SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
            false
        )
        OBJECT_MAPPER.dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    }


    fun toStr(o: Any): String? {
        try {
            return OBJECT_MAPPER.writeValueAsString(o)
        } catch (e: JsonProcessingException) {
            log.error("json序列化成文本失败", e)
        }
        return null
    }

    fun <T> toObj(str: String?, clazz: Class<T>): T? {
        try {
            return OBJECT_MAPPER.readValue(str, clazz)
        } catch (e: Exception) {
            log.error("序列化成对象失败，文本：{}。", str, e)
        }
        return null
    }

    fun <T> toObj(str: String, valueTypeRef: TypeReference<T>): T? {
        try {
            return OBJECT_MAPPER.readValue(str, valueTypeRef)
        } catch (e: Exception) {
            log.error("序列化成对象失败，文本：{}。", str, e)
        }
        return null
    }
}
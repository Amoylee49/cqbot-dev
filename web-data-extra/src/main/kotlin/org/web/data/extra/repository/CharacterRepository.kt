package org.web.data.extra.repository

import com.fasterxml.jackson.core.type.TypeReference
import org.springframework.stereotype.Component
import org.web.data.extra.data.CharacterHolder
import org.web.data.extra.util.JsonUtils
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream

fun main() {
//    JsonUtils.loadCharacterJson()
    println(CharacterRepository().readCharacterAsStream())
}
@Component
class CharacterRepository {


    fun readCharacterAsStream(): String? {
        ClassLoader.getSystemResourceAsStream("Character.json").use { inputStream ->
            val bis = BufferedInputStream(inputStream)
            val bys = ByteArrayOutputStream()
            var result = bis.read()
            while (result != -1) {
                bys.write(result.toByte().toInt())
                result = bis.read()
            }
            val json = bys.toString("UTF-8")
//            return JsonUtils.toObj(json, object : TypeReference<List<CharacterHolder>?>() {})
            return json
        }
    }

}


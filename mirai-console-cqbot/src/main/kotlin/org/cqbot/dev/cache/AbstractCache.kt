package org.cqbot.dev.cache

import com.fasterxml.jackson.core.type.TypeReference
import org.cqbot.dev.data.CharacterHolder
import org.cqbot.dev.data.CustomRule
import org.cqbot.dev.util.JsonUtils
import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.io.ByteArrayOutputStream
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths

abstract class AbstractCache<T> {

    open lateinit var caches: List<T>

    open fun loadCaches() {
        val path = Paths.get(getPath())
        val allLines =  Files.newBufferedReader(path).readText()
        caches = JsonUtils.toObj(allLines, object : TypeReference<List<T>>() {})!!
    }

    abstract fun getAll(): List<T>

    abstract fun getPath(): String
}


/*fun main() {
    print("""E:/JavaProject/cqbot-dev/data/CustomRules.json""")
    val path = Paths.get("""E:/JavaProject/cqbot-dev/data/CustomRules.json""")
    val allLines = Files.newBufferedReader(path).readText()

    Files.lines(path).use {  }

    var json =  JsonUtils.toObj(allLines, object : TypeReference<List<CustomRule>>() {})!!
    print(json)
}*/
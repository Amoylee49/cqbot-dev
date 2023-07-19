package org.cqbot.dev.cache

import java.io.BufferedReader
import java.nio.file.Files
import java.nio.file.Paths

abstract class AbstractCache<T> {

    /* open fun loadCaches() {  //泛型T 现在没有？LinkedHashMap cannot be cast to class org.cqbot.dev.data.CustomRule
         val path = Paths.get(getPath())
         val allLines =  Files.newBufferedReader(path).readText()
         val cacheList = JsonUtils.toObj(allLines, object : TypeReference<List<T>?>() {})!!
         setCache(cacheList)
     //        JsonUtils.toObj(allLines, object : TypeReference<List<CustomRule>?>() {})!!
     }*/

    fun readFile(): BufferedReader {
        val path = Paths.get(getPath())
        return Files.newBufferedReader(path)
    }

    abstract fun loadCaches()

    abstract fun setCache(paramList: List<T>)
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

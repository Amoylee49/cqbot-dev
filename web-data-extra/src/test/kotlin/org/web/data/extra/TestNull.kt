//package org.web.data.extra
//
//import com.fasterxml.jackson.core.type.TypeReference
//import org.web.data.extra.data.CharacterHolder
//import org.web.data.extra.util.JsonUtils
//import java.io.BufferedInputStream
//import java.io.ByteArrayOutputStream
//import java.util.function.Predicate
//import java.util.stream.Collectors
//
//object TestNull {
//
//}
//
//fun main() {
////    val socketTask = SocketTask()
////    socketTask.dataHandle()
//    val str = null
//    var any = str ?: "pptrrrr"
////    var any2 = getIntOrNull()?.equals("") ?: "strrrr"
//    var any3 = getIntOrNull() ?: "strrrr"
////
////
//    println(any)
////    print(any)
////    print(any2)
//    println(any3)
//
//    IntRange(1, 10).forEach { s ->
//        val b = s % 2 == 0
//        println(b)
//    }
//
//    val listChar = readStream()
//
//    val message = "黄毛"
//
//    if (listChar != null) {
//        val collect = listChar.stream()
//            .filter(
//                Predicate { holder: CharacterHolder ->
//                    filterChar(holder, message)
//                }
//            ).map { s: CharacterHolder -> s.character }
//            .collect(Collectors.toList())
//        println(collect)
//    }
//}
//
//fun filterChar(holder: CharacterHolder, rawMessage: String): Boolean {
//    for (s in holder.nickNames) {
//        if (s.startsWith(rawMessage) || s.endsWith(rawMessage)) {
//            return true
//        }
//    }
//    return false
//}
//
//fun getIntOrNull(): Any? {
//    var value = "null"
//    setOf<Any?>(7, "2", null).forEach { s ->
//        return when (s) {
//            "2" -> 2
//            1 -> 1
//            "" -> ""
//            else -> null
//        }
//    }
//    return null
//}
//
//fun readStream(): List<CharacterHolder>? {
//
//    ClassLoader.getSystemResourceAsStream("Character.json").use { inputStream ->
//        val bis = BufferedInputStream(inputStream)
//        val buf = ByteArrayOutputStream()
//        var result = bis.read()
//        while (result != -1) {
//            buf.write(result.toByte().toInt())
//            result = bis.read()
//        }
//        val json = buf.toString("UTF-8")
//        return JsonUtils.toObj(json, object : TypeReference<List<CharacterHolder>?>() {})
//    }
//}

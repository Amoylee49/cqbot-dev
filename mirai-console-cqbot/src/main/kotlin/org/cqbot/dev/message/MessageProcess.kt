package org.cqbot.dev.message

import net.mamoe.mirai.message.data.MessageChain
import java.util.regex.Pattern

abstract class MessageProcess {
    abstract val command: String
    open fun isMatch(message: String): Boolean {
        //个实例：
//        为了提升性能，应该显式地将正则表达式编译成一个 Patter 口实例（不可变），让它成
//        为类初始化的一部分，并将它缓存起来，每当调用 isRomanNumeral 方法的时候就重用同
//        个实例：

        val matcher = Pattern.compile(command, Pattern.CASE_INSENSITIVE)
            .matcher(message)
        return matcher.find()
    }

    fun getCommandParameter(message: String): List<String> {
        val matcher = Pattern.compile(command, Pattern.CASE_INSENSITIVE)
            .matcher(message)
        val trim = matcher.replaceFirst("").trim()
        return trim.split(",")
    }

    abstract fun process(message: String): MessageChain?

}
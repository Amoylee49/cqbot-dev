package org.cqbot.dev.message

import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.PlainText
import net.mamoe.mirai.message.data.buildMessageChain
import org.cqbot.dev.cache.SimpleTextCache
import org.cqbot.dev.constant.Constants.WIKI_PATH
import java.net.URLEncoder

object SimpleTextProcess: MessageProcess() {
    override val command: String = "(^\\s*qr)|(^\\s*查询)"

    override fun process(message: String): MessageChain?{
        val rawMessage = getCommandParameter(message)[0]

        val list = SimpleTextCache.getAll()

        for (text in list){
            if (text.startsWith(rawMessage)|| text.endsWith(rawMessage)){
                return buildMessageChain {
                    +PlainText(text)
                    +PlainText(WIKI_PATH + URLEncoder.encode(text, "utf-8"))
                }
            }
        }
        return null
    }
}
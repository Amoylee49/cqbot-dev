package org.cqbot.dev.message.blhx

import net.mamoe.mirai.message.code.MiraiCode
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.PlainText
import net.mamoe.mirai.message.data.buildMessageChain
import org.cqbot.dev.cache.ShipCache
import org.cqbot.dev.constant.Constants
import org.cqbot.dev.message.MessageProcess
import java.net.URLEncoder
import java.nio.charset.Charset

class ShipMessageProcess : MessageProcess() {

    override val command: String = "(^\\s*qr)|(^\\s*查询)"

    override fun process(message: String): MessageChain? {
        val parameter = getCommandParameter(message)[0].uppercase()
        if (parameter.isBlank())
            return null
        val ships = ShipCache.getAll()
        val ship = ships.stream().filter { ship ->
            ship.name.contains(parameter,ignoreCase = true)||
                    filterNickNames(ship.nickNames, parameter)
        }.findFirst().orElse(null) ?: return null

        val subPrxfix = "url="
        val plainText = PlainText(
            "画家：\t" + ship.painter + "\n"
                    + "微博：" + ship.painterWeibo.substringAfterLast(subPrxfix) + "\n"
                    + "PIXIV：" + ship.painterPIXIV.substringAfterLast(subPrxfix) + "\n"
        )

//        val share = RichMessage.Key.share(Constants.BLHX_WIKI_PATH+ship.name, ship.name, plainText.content, ship.profileImage)
//        return shareByMiraiCode(Constants.BLHX_WIKI_PATH+ship.name,ship.name,plainText.content,ship.profileImage)
        return buildMessageChain {
            +PlainText(ship.name + "\n")
            +PlainText(Constants.BLHX_WIKI_PATH + URLEncoder.encode(ship.name, Charset.defaultCharset()) + "\n")
            if (ship.painter.length > 1) {
                +plainText
            }
        }

    }
    private fun filterNickNames(nickNames: List<String>, param: String): Boolean {
        nickNames.forEach {
            nickName-> if (nickName.contains(param,ignoreCase = true))return true
        }
        return false
    }

    private fun shareByMiraiCode(url: String, title: String, content: String, imageUrl: String): MessageChain {
        var json =
            """[mirai:service:1,<?xml version="1.0" encoding="utf-8"?> <msg templateID="12345" action="web" brief="$content" serviceID="1" url="$url"><item layout="2"><picture cover="$imageUrl"/><title>${title}</title><summary>描述文字</summary></item><source/></msg>\n]"""
        return MiraiCode.deserializeMiraiCode(json)
    }

}
/*
fun main(){
    var prefix = "url="
    var url = "http://game.bilibili.com/linkfilter/?url=https://www.pixiv.net/member.php?id=1393609"
    println(url.substringAfterLast(prefix))
}*/

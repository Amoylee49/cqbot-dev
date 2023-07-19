package org.cqbot.dev.message

import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.PlainText
import net.mamoe.mirai.message.data.buildMessageChain
import org.cqbot.dev.cache.CustomRuleCache
import org.cqbot.dev.cache.SimpleTextCache
import org.cqbot.dev.data.CustomRule
import java.util.stream.Collectors

object TipProcess : MessageProcess() {
    override val command: String = "(^\\s*tip)|(^\\s*命令)"

    override fun process(message: String): MessageChain? {
        val tipMessage = SimpleTextCache.getAll()
        val customRules = CustomRuleCache.getAll()

        val buildMessageChain = buildMessageChain {
            +PlainText(
                "\"支持\n" + tipMessage.toString()+ customRulesMessage(customRules).toString()+
                        "\n等wiki查询。请输入例如qr浦西或者查询浦西\" "
            )
        }
        return buildMessageChain
    }

    private fun customRulesMessage(customRule: List<CustomRule>): MutableList<String>? {
        return  customRule.stream().map { customRule -> customRule.name }
            .collect(Collectors.toList())
    }
}
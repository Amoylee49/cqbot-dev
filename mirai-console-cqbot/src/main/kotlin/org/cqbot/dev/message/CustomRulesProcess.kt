package org.cqbot.dev.message

import org.cqbot.dev.cache.CustomRuleCache
import net.mamoe.mirai.message.data.PlainText
import java.util.stream.Collectors

object CustomRulesProcess : MessageProcess() {
    override val command: String = "(^\\s*qr)|(^\\s*查询)"

    //message qr 夏洛特
    override fun process(message: String): PlainText {
        val parameter = getCommandParameter(message)[0]

        val customRules = CustomRuleCache.getAll()

        val findAny = customRules.stream().filter { customRules ->
            customRules.name.startsWith(parameter) ||
                    customRules.name.endsWith(parameter)
        }.collect(Collectors.toList())

        return PlainText(
            findAny[0].name
                    + findAny[0].data
        )
    }
}
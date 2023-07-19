package org.cqbot.dev.message

import kotlinx.coroutines.currentCoroutineContext
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.PlainText
import net.mamoe.mirai.message.data.buildMessageChain
import org.cqbot.dev.cache.CustomRuleCache

object CustomRulesProcess : MessageProcess() {
    override val command: String = "(^\\s*qr)|(^\\s*查询)"

    //message qr 夏洛特
    override fun process(message: String): MessageChain? {
        val rawMessage = getCommandParameter(message)[0]

        val customRules = CustomRuleCache.getAll()

        customRules.forEach { customRule ->
            if (customRule.name.startsWith(rawMessage) || customRule.name.endsWith(rawMessage)) {
//                print("=========    ${customRule.name} ${customRule.data}     ========")
                return buildMessageChain {
                    +PlainText(customRule.name+"\n"+ customRule.data)
                }
            }
        }
        return null
    }

}
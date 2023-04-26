package org.cqbot.dev

import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.event.events.BotInvitedJoinGroupRequestEvent
import net.mamoe.mirai.event.events.FriendMessageEvent
import net.mamoe.mirai.event.events.NewFriendRequestEvent

object BotdevMain : KotlinPlugin(
    JvmPluginDescription(
        id = "org.example.mirai-cq-KOTLIN",
        name = "示例 --- mirai-cq-KOTLIN",
        version = "0.1.0"
    ) {
        author("作者名称或联系方式")
        info(
            """
            这是一个测试插件, 
            在这里描述插件的功能和用法等.
        """.trimIndent()
        )
        // author 和 info 可以删除.
    }
) {
    override fun onEnable() {
//        logger.info { "Plugin loaded" }

        val eventChannel = GlobalEventChannel.parentScope(this)

        GroupChannel.subEventChannel(eventChannel)

        eventChannel.subscribeAlways<FriendMessageEvent> {
            //好友信息
//            sender.sendMessage("hi")
        }
        eventChannel.subscribeAlways<NewFriendRequestEvent> {
            //自动同意好友申请
            accept()
        }
        eventChannel.subscribeAlways<BotInvitedJoinGroupRequestEvent> {
            //自动同意加群申请
            accept()
        }
    }
}
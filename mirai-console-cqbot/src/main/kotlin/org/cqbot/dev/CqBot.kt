package org.cqbot.dev

import org.cqbot.dev.cache.CharacterCache
import org.cqbot.dev.cache.CustomRuleCache
import org.cqbot.dev.cache.SimpleTextCache
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.event.events.BotInvitedJoinGroupRequestEvent
import net.mamoe.mirai.event.events.FriendMessageEvent
import net.mamoe.mirai.event.events.NewFriendRequestEvent
import org.cqbot.dev.cache.ShipCache
import org.cqbot.dev.constant.Constants
import org.cqbot.dev.constant.Constants.characterFileName
import org.cqbot.dev.constant.Constants.customRuleFileName
import org.cqbot.dev.constant.Constants.shipFileName
import org.cqbot.dev.constant.Constants.simpleTransferFileName
import org.cqbot.dev.setting.MainSetting
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

//插件主入口 META-INF.services
object CqBot : KotlinPlugin(JvmPluginDescription(
    id = "org.cqbot.dev",
    name = "######### KotlinPlugin 示例 信息 ##############",
    version = "1.1.0"
) {
    author("作者名称或联系方式")
    info(
        """
            这是一个测试插件, 
            在这里描述插件的功能和用法等.
        """.trimIndent()
    )
    // author 和 info 可以删除.
}) {
    private val log: Logger = LoggerFactory.getLogger(this::class.java)
    override fun onEnable() {

        MainSetting.reload() // 从数据库自动读取配置实例

        checkSettingAndLoadFile() //加载数据

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

    private fun checkSettingAndLoadFile(){

        listOf(shipFileName,characterFileName, customRuleFileName, simpleTransferFileName).stream().forEach {
           var abstractPath = MainSetting.filePath+it
            log.info("这是文件名路径{}",abstractPath)
            if (!File(abstractPath).exists())
                log.error("机器人未找到配置文件")
        }

        var list = listOf(ShipCache,CharacterCache, CustomRuleCache, SimpleTextCache)
//        var list = listOf(ShipCache)

        list.forEach {
            it.loadCaches()
        }
    }

}
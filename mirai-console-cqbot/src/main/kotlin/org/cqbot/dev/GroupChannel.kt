package org.cqbot.dev

import org.cqbot.dev.message.CustomRulesProcess
import org.cqbot.dev.message.HeroMessageProcess
import org.cqbot.dev.message.MessageProcess
import net.mamoe.mirai.event.Event
import net.mamoe.mirai.event.EventChannel
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.message.data.buildMessageChain
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.InputStream
import java.net.URL

object GroupChannel {

    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    fun subEventChannel(eventChannel: EventChannel<Event>) {
        log.info("++++++++++++++++ PluginLoad 加载成功 +++++++++++")
        val listProcess = listOf<MessageProcess>(HeroMessageProcess, CustomRulesProcess)
        //配置文件目录 "${dataFolder.absolutePath}/"
//        val eventChannel = GlobalEventChannel.parentScope(this)
        eventChannel.subscribeAlways<GroupMessageEvent> {
            //群消息
            val rawMessage = message.contentToString()
            for (messageProcess in listProcess) {
                if (!messageProcess.isMatch(rawMessage)) continue
                val messageChain = messageProcess.process(rawMessage) as MessageChain
                group.sendMessage(messageChain)
                //不继续处理
                return@subscribeAlways
            }

            /* 发送image参考：
        //如何发送图片： https://github.com/mamoe/mirai/discussions/864
         eventChannel.subscribeAlways<GroupMessageEvent> {
             //① 将文件转为 ExternalResource，指定格式或不指定
             group.sendImage(File("jpg_image_path").toExternalResource("jpg"))
             //② 先上传图片，获得 Image
             group.uploadImage(File("png_image_path").toExternalResource("png")).also {
                 // ② 和其他类型消息一起发送
                 group.sendMessage(buildMessageChain {
                     add(PlainText("plain"))
                     add(it)
                 })
                 // ② 直接发送
                 group.sendMessage(it)
             }
             //直接传入 File 和 图片格式
             group.sendImage(File("img_path"), "bmp")
             //直接传入 InputStream 和 图片格式
             group.sendImage(File("file").inputStream(), "gif")
         }*/


            /*if (messageProcess.isMatch(rawMessage)) {
                val messChain = messageProcess.process(rawMessage)
                if (messChain != null) {
                    val imageUrl = messChain[0].contentToString()
                    // kotlin
                    val inputStream: InputStream = URL(imageUrl).openStream()
                    val resource = inputStream.use { it.toExternalResource().toAutoCloseable() }
                    //② 先上传图片，获得 Image
                    group.uploadImage(resource).also {
                        // ② 和其他类型消息一起发送
                        group.sendMessage(buildMessageChain {
                            add(it)
                            for (singleMess in messChain.drop(1)) { // i in [1, 10), 不包含 10
                                add(singleMess)
                            }
                        })
                    }
                }
            }*/
        }
    }
}
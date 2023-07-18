package org.cqbot.dev.setting

import net.mamoe.mirai.console.data.ReadOnlyPluginConfig
import net.mamoe.mirai.console.data.ValueDescription
import net.mamoe.mirai.console.data.value

object MainSetting : ReadOnlyPluginConfig("mainSetting") {

    @ValueDescription("path路径") // 注释, 将会保存在 mainSetting.yml 文件中.
    val filePath by value("E:\\JavaProject\\cqbot-dev\\data\\/")
}
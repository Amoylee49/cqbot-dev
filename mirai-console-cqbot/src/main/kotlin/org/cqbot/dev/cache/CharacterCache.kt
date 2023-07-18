package org.cqbot.dev.cache

import org.cqbot.dev.constant.Constants
import org.cqbot.dev.data.CharacterHolder
import org.cqbot.dev.setting.MainSetting
object CharacterCache : AbstractCache<CharacterHolder>() {
    override fun getPath(): String {
        return MainSetting.filePath+Constants.characterFileName
    }

    override fun  getAll(): List<CharacterHolder> {
        return caches
    }
}
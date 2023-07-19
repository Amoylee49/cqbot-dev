package org.cqbot.dev.cache

import org.cqbot.dev.constant.Constants
import org.cqbot.dev.setting.MainSetting

object SimpleTextCache : AbstractCache<String>() {

    override fun getPath(): String {
        return MainSetting.filePath + Constants.simpleTransferFileName
    }

    override fun loadCaches() {
        val readLines = super.readFile().readLines()
        this.setCache(readLines)
    }

}
package org.cqbot.dev.cache

import org.cqbot.dev.constant.Constants
import org.cqbot.dev.setting.MainSetting
import java.nio.file.Files
import java.nio.file.Paths

object SimpleTextCache: AbstractCache<String>() {

    private lateinit var caches: List<String>
    override fun getAll(): List<String> {
        return this.caches
    }

    override fun getPath(): String {
        return MainSetting.filePath+Constants.simpleTransferFileName
    }

    override fun loadCaches() {
        val path = Paths.get(getPath())
        val allLines =  Files.newBufferedReader(path).readLines()
        this.setCache(allLines)
    }

    override fun setCache(paramList: List<String>) {
        this.caches = paramList
    }
}
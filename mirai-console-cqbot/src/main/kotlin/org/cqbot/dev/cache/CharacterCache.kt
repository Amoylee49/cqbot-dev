package org.cqbot.dev.cache

import com.fasterxml.jackson.core.type.TypeReference
import org.cqbot.dev.constant.Constants
import org.cqbot.dev.data.CharacterHolder
import org.cqbot.dev.setting.MainSetting
import org.cqbot.dev.util.JsonUtils
import java.nio.file.Files
import java.nio.file.Paths

object CharacterCache : AbstractCache<CharacterHolder>() {
    private lateinit var caches: List<CharacterHolder>
    override fun getPath(): String {
        return MainSetting.filePath+Constants.characterFileName
    }

    override fun setCache(paramList: List<CharacterHolder>) {
        this.caches = paramList
    }

    override fun loadCaches() {
        val path = Paths.get(getPath())
        val allLines =  Files.newBufferedReader(path).readText()
        val cacheList = JsonUtils.toObj(allLines, object : TypeReference<List<CharacterHolder>?>() {})!!
        setCache(cacheList)
    }

    override fun  getAll(): List<CharacterHolder> {
        return this.caches
    }
}
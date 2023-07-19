package org.cqbot.dev.cache

import com.fasterxml.jackson.core.type.TypeReference
import org.cqbot.dev.constant.Constants
import org.cqbot.dev.data.CharacterHolder
import org.cqbot.dev.data.CustomRule
import org.cqbot.dev.setting.MainSetting
import org.cqbot.dev.util.JsonUtils
import java.nio.file.Files
import java.nio.file.Paths

object CustomRuleCache: AbstractCache<CustomRule>() {

    private lateinit var caches: List<CustomRule>
    override fun setCache(paramList: List<CustomRule>) {
        this.caches = paramList
    }

    override fun loadCaches() {
        val path = Paths.get(getPath())
        val allLines =  Files.newBufferedReader(path).readText()
        val cacheList = JsonUtils.toObj(allLines, object : TypeReference<List<CustomRule>?>() {})!!
        this.setCache(cacheList)
    }

    override fun getAll(): List<CustomRule> {
       return this.caches
    }

    override fun getPath(): String {
      return MainSetting.filePath+Constants.customRuleFileName
    }

  /*  override fun toString(): String {
        return this.caches.forEach { customRule ->
            customRule.name
        }.toString()
    }*/
}
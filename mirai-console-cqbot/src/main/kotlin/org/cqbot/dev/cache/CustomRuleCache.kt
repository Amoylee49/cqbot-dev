package org.cqbot.dev.cache

import com.fasterxml.jackson.core.type.TypeReference
import org.cqbot.dev.constant.Constants
import org.cqbot.dev.data.CustomRule
import org.cqbot.dev.setting.MainSetting
import org.cqbot.dev.util.JsonUtils

object CustomRuleCache : AbstractCache<CustomRule>() {

    override fun loadCaches() {
        val allLines = super.readFile().readText()
        val cacheList = JsonUtils.toObj(allLines, object : TypeReference<List<CustomRule>?>() {})!!
        this.setCache(cacheList)
    }

    override fun getPath(): String {
        return MainSetting.filePath + Constants.customRuleFileName
    }

    /*  override fun toString(): String {
          return this.caches.forEach { customRule ->
              customRule.name
          }.toString()
      }*/
}
/*
fun main(){
    //测试
//    "E:\\JavaProject\\cqbot-dev\\data\\"+Constants.customRuleFileName
    CustomRuleCache.loadCaches()
    print(CustomRuleCache.getAll())
}*/

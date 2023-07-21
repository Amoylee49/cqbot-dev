package org.cqbot.dev.cache

import com.fasterxml.jackson.core.type.TypeReference
import org.cqbot.dev.blhx.data.Ship
import org.cqbot.dev.constant.Constants
import org.cqbot.dev.setting.MainSetting
import org.cqbot.dev.util.JsonUtils
import java.util.Date

object ShipCache: AbstractCache<Ship>() {
    override fun loadCaches() {
        val readText = this.readFile().readText()
        val toObj = JsonUtils.toObj(readText, object : TypeReference<List<Ship>>() {})!!
        this.setCache(toObj)
    }

    override fun getPath(): String {
        return MainSetting.filePath+Constants.shipFileName
//        return "E:\\JavaProject\\cqbot-dev\\data\\"+Constants.shipFileName
    }
}

/*
fun main(){
    ShipCache.loadCaches()
    println(ShipCache.getAll())
}*/

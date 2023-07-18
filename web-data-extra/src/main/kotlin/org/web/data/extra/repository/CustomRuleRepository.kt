package org.web.data.extra.repository

import com.fasterxml.jackson.core.type.TypeReference
import org.cqbot.dev.data.CustomRule
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.web.data.extra.config.CqBotConfig
import org.web.data.extra.util.JsonUtils
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.io.path.name

@Component
class CustomRuleRepository : NormalFileRepository<CustomRule>() {
    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    @Autowired
    lateinit var cqBotConfig: CqBotConfig
    override fun getFilePath(): String {
        return cqBotConfig.filePath + "CustomRules.json"
//        return "E:\\JavaProject\\cqbot-dev\\data\\CustomRules.json"
    }

    override fun getAll(): List<CustomRule> {
        val fileName = Paths.get(getFilePath())
//        print(fileName.name) //CustomRules.json
        val readText = Files.newBufferedReader(fileName).readText()
        return JsonUtils.toObj(readText, object : TypeReference<List<CustomRule>?>() {})!!

//        try {
//            return JsonUtils.toObj(json, object : TypeReference<List<CustomRule>>() {})!!
//        } catch (e: Exception) {
//            log.error("CustomRuleRepository getAll error: $e")
//        }
    }

    override fun processDelete(paramT: CustomRule, paramList: List<CustomRule>): List<CustomRule> {
        val customRuleList = paramList as ArrayList
        customRuleList.removeIf {
            it.name == paramT.name
        }
        return customRuleList
    }


}
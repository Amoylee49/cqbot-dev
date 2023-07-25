package org.cqbot.dev

import org.apache.commons.io.monitor.FileAlterationListener
import org.apache.commons.io.monitor.FileAlterationObserver
import org.cqbot.dev.cache.CharacterCache
import org.cqbot.dev.cache.CustomRuleCache
import org.cqbot.dev.cache.ShipCache
import org.cqbot.dev.cache.SimpleTextCache
import org.cqbot.dev.constant.Constants.characterFileName
import org.cqbot.dev.constant.Constants.customRuleFileName
import org.cqbot.dev.constant.Constants.shipFileName
import org.cqbot.dev.constant.Constants.simpleTransferFileName
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

object CqBotFileListener : FileAlterationListener {
    private val log: Logger = LoggerFactory.getLogger(this::class.java)
    override fun onDirectoryChange(directory: File) {
        log.info("onDirectoryChange:${directory.name}")
    }

    override fun onDirectoryCreate(directory: File?) {

    }

    override fun onDirectoryDelete(directory: File?) {

    }

    override fun onFileChange(file: File) {
        when(file.name){
            characterFileName -> CharacterCache.loadCaches()
            customRuleFileName -> CustomRuleCache.loadCaches()
            simpleTransferFileName -> SimpleTextCache.loadCaches()
            shipFileName -> ShipCache.loadCaches()
        }
        log.info("Cq机器人重新加载配置文件:${file.name}")
    }

    override fun onFileCreate(file: File?) {

    }

    override fun onFileDelete(file: File?) {

    }

    override fun onStart(observer: FileAlterationObserver) {
        log.info("Cq机器人FileListener OnStart")
    }

    override fun onStop(observer: FileAlterationObserver?) {
        log.info("Cq机器人FileListener OnStop")
    }
}
package org.web.data.extra.controller

import jakarta.annotation.Resource
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.web.data.extra.service.CacheChatacterServer
import org.web.data.extra.service.IServer
import org.web.data.extra.util.JsonUtils
import java.io.File
import java.io.IOException
import java.io.Writer
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.bufferedWriter
import kotlin.io.path.createDirectories
import kotlin.io.path.createFile
import kotlin.io.path.exists

@RestController
class CharacterController {

    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    @Resource
    lateinit var webCharacterService: IServer

    @RequestMapping("/refresh")
    fun refresh(): String {
//        val holderList = webCharacterService.cacheWebCharacters()

        var strs = "w34234"

        var path = Paths.get("data1\\Character.json")

        if (!path.exists()){
            log.info(path.exists().toString())
//            path.createDirectories()
            Files.createFile(path)
        }
        try {
            Files.newBufferedWriter(path, StandardCharsets.UTF_8).use { writer ->
                writer.write(strs)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return strs
    }
}

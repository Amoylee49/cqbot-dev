package org.web.data.extra.controller

import jakarta.annotation.Resource
import org.cqbot.dev.data.CharacterHolder
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.web.data.extra.data.StatusResponse
import org.web.data.extra.service.CacheCharacterServer
import org.web.data.extra.util.ResponseUtils
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import kotlin.io.path.*

@RestController
class CharacterController {

    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    @Resource
    lateinit var characterService: CacheCharacterServer

    private var threadPool: ThreadPoolExecutor = ThreadPoolExecutor(
        1, 1,
        0L, TimeUnit.MILLISECONDS,
        SynchronousQueue(), ThreadPoolExecutor.AbortPolicy()
    )

    constructor()

    @RequestMapping("/getAll")
    fun getAllCharacters(): StatusResponse<List<CharacterHolder>> {
        return ResponseUtils.OK(characterService.getAllCharacters())
    }

    @GetMapping("/refreshAll")
    fun refreshAllCharacters(): StatusResponse<String> {

        try {
            threadPool.execute {
                characterService.refreshAll()
            }
        } catch (e: Exception) {
            return ResponseUtils.OK("刷新人物进行中，中")
        }
        return ResponseUtils.OK("刷新人物中")
    }


    @RequestMapping("/refresh")
    fun refresh(): String {
//        val holderList = webCharacterService.cacheWebCharacters()

        var strs = "w34234"

        var path = Paths.get("data1\\Character.json")

        if (!path.exists()) {
//            log.info(path.exists().toString())
            Files.createDirectory(Paths.get("data1"))
//            Files.createFile(path)
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

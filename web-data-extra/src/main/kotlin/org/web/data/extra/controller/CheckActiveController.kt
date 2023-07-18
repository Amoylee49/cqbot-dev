package org.web.data.extra.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.web.data.extra.data.StatusResponse
import org.web.data.extra.util.ResponseUtils
import java.util.concurrent.SynchronousQueue

import java.util.concurrent.TimeUnit




@RestController
class CheckActiveController {
    @RequestMapping("check")
    fun check(): StatusResponse<String> {
        return ResponseUtils.OK("true")
    }


//    private var refreshPool: ThreadPoolExecutor? = null
//
//    fun CharacterController(@NotNull characterService: CharacterService, @NotNull status: CharacterRefreshAllStatus) {
//        characterService = characterService
//        status = status
//        this.log = LoggerFactory.getLogger(CharacterController::class.java)
//        refreshPool = ThreadPoolExecutor(
//            1, 1,
//            0L, TimeUnit.MILLISECONDS,
//            SynchronousQueue<E>(), AbortPolicy()
//        )
//    }
}
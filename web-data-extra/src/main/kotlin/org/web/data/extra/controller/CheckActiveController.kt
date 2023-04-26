package org.web.data.extra.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CheckActiveController {
    @RequestMapping("check")
    fun check(): Boolean {
        return true
    }
}
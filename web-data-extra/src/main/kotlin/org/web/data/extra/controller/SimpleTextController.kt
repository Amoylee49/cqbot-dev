package org.web.data.extra.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.web.data.extra.data.StatusResponse
import org.web.data.extra.repository.SimpleTextRepository
import org.web.data.extra.service.SimpleTextService
import org.web.data.extra.util.ResponseUtils

@RestController
@RequestMapping("/simple")
class SimpleTextController {

    @Autowired
    lateinit var simpleTextService: SimpleTextService
    @GetMapping("/getAll")
    fun getAll(): StatusResponse<List<String>> {
        return ResponseUtils.OK(simpleTextService.getAllText())
    }

    @GetMapping("/delete")
    fun delete(text: String): StatusResponse<Unit> {
        return ResponseUtils.OK(simpleTextService.delete(text))
    }

    @GetMapping("/addOrUpdate")
    fun addOrUpdate(text: String): StatusResponse<Unit> {
        return ResponseUtils.OK(simpleTextService.addOrUpdateText(text))
    }


}
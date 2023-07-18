package org.web.data.extra.controller

import org.cqbot.dev.data.CustomRule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.web.data.extra.data.StatusResponse
import org.web.data.extra.service.CustomRuleServer
import org.web.data.extra.util.ResponseUtils

@RestController
@RequestMapping("/customRules")
class CustomRuleController {


    @Autowired
    private lateinit var customRuleServer: CustomRuleServer

    @GetMapping("/getAll")
    fun getAllCustomRules(): StatusResponse<List<CustomRule>?> {
        return ResponseUtils.OK(customRuleServer.getAllCustomRules())
    }

    @GetMapping("/addOrUpdate")
    fun addOrUpdate(customRule: CustomRule): StatusResponse<Unit> {
        return ResponseUtils.OK(customRuleServer.addOrUpdate(customRule))
    }

    @GetMapping("/delete")
    fun delete(customRule: CustomRule): StatusResponse<Unit> {
        return ResponseUtils.OK(customRuleServer.delete(customRule))
    }


}
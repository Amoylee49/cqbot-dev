package org.web.data.extra.service

import org.cqbot.dev.data.CustomRule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.web.data.extra.data.StatusResponse
import org.web.data.extra.repository.CustomRuleRepository
import org.web.data.extra.util.ResponseUtils


@Service
class CustomRuleServer : IServer {

    @Autowired
    private lateinit var customRuleRepository: CustomRuleRepository

    fun getAllCustomRules(): List<CustomRule>? {
        return customRuleRepository.getAll()
    }

    fun addOrUpdate(customRule: CustomRule) {
        return customRuleRepository.addOrUpdate(customRule)
    }
    fun delete(customRule: CustomRule){
        customRuleRepository.delete(customRule)
    }

//    @GetMapping(path = ["/getByName"])
//    fun getCharacterByName(@RequestParam("name") @NotNull name: String?): StatusResponse<CharacterHolder?>? {
//        Intrinsics.checkNotNullParameter(name, "name")
//        return ResponseUtils.Companion.ok(getCharacterService().getCharacterByName(name))
//    }


}
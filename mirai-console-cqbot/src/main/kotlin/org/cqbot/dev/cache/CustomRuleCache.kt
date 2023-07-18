package org.cqbot.dev.cache

import org.cqbot.dev.constant.Constants
import org.cqbot.dev.data.CustomRule
import org.cqbot.dev.setting.MainSetting

object CustomRuleCache: AbstractCache<CustomRule>() {

    override fun getAll(): List<CustomRule> {
       return this.caches
    }

    override fun getPath(): String {
      return MainSetting.filePath+Constants.customRuleFileName
    }
}
package org.web.data.extra.service

import org.cqbot.dev.data.CharacterHolder
import org.cqbot.dev.data.CustomRule

interface IServer {
    fun getAllCharactersFromWeb(): List<CharacterHolder> {
        return emptyList()
    }

    open fun loadCustomFile(): List<CustomRule>{
        return listOf()
    }
//
//
}
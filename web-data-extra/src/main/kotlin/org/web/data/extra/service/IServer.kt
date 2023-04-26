package org.web.data.extra.service

import org.web.data.extra.data.CharacterHolder
import org.web.data.extra.data.Characters

interface IServer {
     fun cacheWebCharacters(): List<CharacterHolder>

     fun loadCustomFile(): List<String>
}
package org.web.data.extra.data

import java.util.*

data class CharacterHolder(
    val nickNames: MutableList<String> = LinkedList(),
    var character: Character? = null
) {
//    constructor() : this(
//        listOf(),
//    )

    fun addNickName(nickName : String){
        nickNames.add(nickName)
    }
}
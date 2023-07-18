package org.cqbot.dev.data

import java.util.*

data class CharacterHolder(
    val nickNames: MutableList<String> = LinkedList(),
    var character: Character = Character()
) {
//    constructor() : this(
//        listOf(),
//    )

    fun addNickName(nickName : String){
        nickNames.add(nickName)
    }
}
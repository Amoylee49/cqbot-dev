package org.cqbot.dev.data

data class Characters (
    val character: Character,
    val nickNames : ArrayList<String> = ArrayList(),

){
    fun addNickName(nickName: String) {
//        val strings = java.util.ArrayList<String>()
//        strings.add("34")
        nickNames.add(nickName)
    }
}
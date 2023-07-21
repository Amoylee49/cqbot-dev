package org.cqbot.dev.blhx.data

import java.util.LinkedList

data class Ship(

    var name: String= "",
    var pageUrl: String= "",
    var nickNames: MutableList<String> = LinkedList(),
    //编号
    var NO: String="",

    val type: ArrayList<String> = ArrayList(),

    val camp: MutableList<String> = ArrayList(),
    //稀有度
    val rarity: MutableList<String> = ArrayList(),

    var profileImage: String = "",

    var painter: String= "",
    var painterWeibo: String= "",
    var painterTwitter: String= "",
    var painterPIXIV: String= "",

    ) {

    fun addNickNames(){
        this.nickNames
    }
}
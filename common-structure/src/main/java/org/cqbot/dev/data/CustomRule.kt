package org.cqbot.dev.data

//序列化报错 cannot deserialize from Object value (no delegate- or property-based Creator)
data class CustomRule(
    var name: String="",
    var data: String="",
){
    //要有一个无参构造
//    constructor():this("","")
}
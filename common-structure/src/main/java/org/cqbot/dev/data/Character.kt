package org.cqbot.dev.data

import java.sql.Timestamp


data class Character(

    var name: String,
    var title: String,
    var content: String,
    var pageUrl: String,
    var imageUrl: String,
    var createTime: Timestamp?
){
    constructor():this(
        "","","","","",
        null
    )
}
package org.bot.dev.service

import org.bot.dev.utils.JsonUtils
import org.cqbot.dev.blhx.data.Ship
import org.cqbot.dev.constant.Constants
import org.cqbot.dev.constant.Constants.WIKI_BASE_PATH
import org.jsoup.Jsoup
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.*

@Service
class ParseShipServer {
    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    lateinit var ship: List<Ship>

    //保存文件到data文件夹
    fun saveShipFile() {
        val ships = parseShipFromWeb()
//        println(ships.size)
        val toObj = JsonUtils.toStr(ships)
        Files.newBufferedWriter(Paths.get("data/ship.json")).use {
            it.write(toObj)
        }
//        Files.writeString(Paths.get("data/ship45.json"), str)
    }

    //解析舰船图鉴
    fun parseShipFromWeb(): List<Ship> {
        var url = Constants.BLHX_WIKI_PATH + "舰船图鉴";
        log.info("访问英雄类型界面：{}", url)
        val shipElements = Jsoup.connect(url).get().getElementsByClass("jntj-1 divsort")

        var shipList: LinkedList<Ship> = LinkedList()
        for (element in shipElements) {
            val pageUrl = WIKI_BASE_PATH + element.select("div>span>a").attr("href")
            val title = element.select("div>span>a").attr("title")
            val profileUrl = element.select("div>div.jntj-2>img").attr("src")

            val shipPage = processShipPage(pageUrl, title, profileUrl)
            log.info("访问舰炮界面：{}", shipPage.toString())
            shipList.add(shipPage)
        }
        return shipList
    }

    fun processShipPage(pageUrl: String, shipName: String, profileUrl: String): Ship {
        val ship = Ship()

        val document = Jsoup.connect(pageUrl).get()
        val decisive = document.select("table.sv-general>tbody>tr:nth-child(1)>td>b,table.sv-general>tbody>tr:nth-child(1)>td>span")
        val typeIcon = document.select("table.sv-general>tbody> tr:nth-child(2) > td:nth-child(5)>a>img").attr("src")
        val typeName = document.select("table.sv-general>tbody> tr:nth-child(2) > td:nth-child(5)>a").attr("title")
        ship.name = shipName
        ship.name = pageUrl
        ship.nickNames.addAll(decisive.eachText())
        ship.profileImage = profileUrl
        ship.painter = document.select(".wikitable.sv-portrait>tbody>tr:nth-child(14)>td").text()
        ship.painterWeibo = document.select(".wikitable.sv-portrait>tbody>tr:nth-child(15)>td>a").attr("href")
        ship.painterTwitter = document.select(".wikitable.sv-portrait>tbody>tr:nth-child(16)>td>a").attr("href")
        ship.painterPIXIV = document.select(".wikitable.sv-portrait>tbody>tr:nth-child(17)>td>a").attr("href")
        return ship
    }

}

fun main() {
    ParseShipServer().saveShipFile()
}
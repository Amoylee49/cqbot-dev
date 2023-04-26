package org.web.data.extra.service

import org.jsoup.Jsoup
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.web.data.extra.constant.Constants.CHARACTER_TYPE
import org.web.data.extra.constant.Constants.ETC
import org.web.data.extra.constant.Constants.THIRTY
import org.web.data.extra.constant.Constants.WIKI_BASE_PATH
import org.web.data.extra.constant.Constants.WIKI_PATH
import org.web.data.extra.data.Character
import org.web.data.extra.data.CharacterHolder
import java.util.*

//@Slf4j
@Service
class CacheChatacterServer : IServer {
    private val log: Logger = LoggerFactory.getLogger(this::class.java)


    override fun cacheWebCharacters(): List<CharacterHolder> {
        val successOrNot = cacheAllCharacterFromWeb()
        log.info("缓存成功了没{}", successOrNot)
        return getAllCharacters()
    }

    private lateinit var characters: List<CharacterHolder>

    fun cacheAllCharacterFromWeb(): Boolean {
        characters = generateAllFromWeb()
        return characters.isNotEmpty()
    }

    fun getAllCharacters(): List<CharacterHolder> {
        return characters
    }

    private fun generateAllFromWeb(): List<CharacterHolder> {
        var result: LinkedList<CharacterHolder> = LinkedList()
        for (type in CHARACTER_TYPE) {
            var url = WIKI_PATH + type

            result.addAll(processTypePage(url))
        }
        return result
    }

    private fun processTypePage(url: String): List<CharacterHolder> {
//        var document : Document;

        log.info("访问英雄类型界面：{}", url)
        var document = Jsoup.connect(url).get()

        var listHolder: LinkedList<CharacterHolder> = LinkedList()
        val elements = document.getElementsByClass("solo_hero_box")

        for (e in elements) {
            var heroName = e.select("div.name>span>b").text()
            var heroUrl = WIKI_BASE_PATH + e.select("div.img>a").attr("href")

            var characterHolder: CharacterHolder =
                processHeroPage(heroUrl, heroName)
            listHolder.add(characterHolder)
        }

        return listHolder
    }


    private fun processHeroPage(heroUrl: String, heroName: String): CharacterHolder {
        var character = Character()
        log.info("访问具体英雄页面：{}", heroUrl)
        var document = Jsoup.connect(heroUrl).get()

        val heroImgUrl = document.select("div.cqhero_img>img").attr("src")

        character.imageUrl = defaultImgUrl(heroImgUrl)
        character.pageUrl = heroUrl
        character.name = heroName
        character.title = document.title()
        character.content = processContent(
            document.select("div.hero_story").text(),
            document.select("div.quote-box").text()
        )

        val characterHolder = CharacterHolder()
        characterHolder.character = character
        characterHolder.addNickName(heroName)
        for (ele in document.select("div.cqframe_oth-name>p>span"))
            characterHolder.addNickName(ele.text())
        return characterHolder
    }

    private fun processContent(heroStory: String, quote: String): String {
        var result = heroStory

        result = if (heroStory.isNullOrEmpty()) quote else heroStory

        if (result.length > THIRTY)
            result = result.substring(0, THIRTY) + ETC
        return result
    }

    private fun defaultImgUrl(heroImgUrl: String): String {
        return if (heroImgUrl.isNullOrEmpty()) WIKI_BASE_PATH else heroImgUrl
    }

    override fun loadCustomFile(): List<String> {
        TODO("Not yet implemented")
    }
}

//fun main() {
//
//    val server = CacheChatacterServer()
//    println(server.defaultImgUrl(""))
//    println(server.defaultImgUrl(null))
//    println(server.defaultImgUrl("小山"))
//    println(server.defaultImgUrl("null"))
//    print(3423)
//}
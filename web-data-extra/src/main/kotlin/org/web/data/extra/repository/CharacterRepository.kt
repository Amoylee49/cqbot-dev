package org.web.data.extra.repository

import com.fasterxml.jackson.core.type.TypeReference
import org.cqbot.dev.data.CharacterHolder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.web.data.extra.config.CqBotConfig
import org.web.data.extra.util.JsonUtils
import java.nio.file.Files
import java.nio.file.Paths

//fun main() {
////    JsonUtils.loadCharacterJson()
//    println(CharacterRepository().readCharacterAsStream())
//}
@Component
class CharacterRepository : NormalFileRepository<CharacterHolder>() {

    @Autowired
    lateinit var botConfig: CqBotConfig

    override fun getFilePath(): String {
        return botConfig.filePath + "Characters.json"
//        return "E:\\JavaProject\\cqbot-dev\\data\\"+"Characters.json"
    }

    override fun getAll(): List<CharacterHolder> {
        val fileName = Paths.get(getFilePath())
//        print(fileName.name)
        val readText = Files.newBufferedReader(fileName).readText()
        return JsonUtils.toObj(readText, object : TypeReference<List<CharacterHolder>?>() {})!!
    }

    override fun processDelete(paramT: CharacterHolder, paramList: List<CharacterHolder>): List<CharacterHolder> {
        var characterList = ArrayList<CharacterHolder>()
        characterList.removeIf { it ->
            it.character.pageUrl == paramT.character.pageUrl
        }
        return characterList
    }

}

/*
fun main(){
//    println(CharacterRepository().getAll())
//    println(CustomRuleRepository().getAll())
//    println(SimpleTextRepository().getAll())
    //val all = CustomRuleRepository().getAll()
//    println(all[0].name)
//    println(all[0].data)
}
*/

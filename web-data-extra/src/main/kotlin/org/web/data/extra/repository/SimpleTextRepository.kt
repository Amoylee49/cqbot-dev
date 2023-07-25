package org.web.data.extra.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.web.data.extra.config.CqBotConfig
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths


@Component
class SimpleTextRepository : NormalFileRepository<String>() {

    @Autowired
    lateinit var cqBotConfig: CqBotConfig
    override fun getFilePath(): String? {
        return cqBotConfig.filePath + "SimpleTransfers.txt"
//        return "data/SimpleTransfers.txt"
    }

    override fun getAll(): List<String> {
        val path = Paths.get(getFilePath())
        return Files.newBufferedReader(path).readLines()
//            https://www.techiedelight.com/zh/split-a-string-on-newline-in-kotlin/
//        return readline.toString().split("\\r?\\n".toRegex())
    }

    override fun processDelete(paramT: String, paramList: List<String>): List<String> {
        val list = paramList as ArrayList
        list.removeIf { list -> (list == paramT) }
        return list
    }
}

/*
fun main() {
//    println(SimpleTextRepository().getAll())

    val split = """lsd  kjf.
            |lsd     kfj.
            | sdf  """.trimMargin().split("\\r?\\n|\\r| ".toRegex())
    println(split.size)
}*/

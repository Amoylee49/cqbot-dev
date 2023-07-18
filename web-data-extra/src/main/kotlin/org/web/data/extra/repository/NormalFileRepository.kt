package org.web.data.extra.repository

import org.web.data.extra.util.JsonUtils
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths

abstract class NormalFileRepository<T> {

    abstract fun getFilePath(): String?
    abstract fun getAll(): List<T>

    fun addOrUpdate(record: T){
        saveAll(processAddOrUpdate(record,getAll()))
    }

    fun delete(record: T) {
        saveAll(processDelete(record,getAll()))
    }


    private fun processAddOrUpdate(record: T, records: List<T>): List<T> {
        var result = processDelete(record, records) as ArrayList
        result.add(record)
        println(result)
        return result
    }

    fun saveAll(records: List<T>){
        var str = JsonUtils.toStr(records)

        return Files.newBufferedWriter(Paths.get(getFilePath()), Charset.defaultCharset())
            .use { write ->
                write.write(str)
            }
    }

    abstract fun processDelete(paramT: T, paramList: List<T>): List<T>
}
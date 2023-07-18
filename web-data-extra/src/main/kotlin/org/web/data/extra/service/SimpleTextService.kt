package org.web.data.extra.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.web.data.extra.repository.SimpleTextRepository

@Service
class SimpleTextService {

    @Autowired
    lateinit var simpleTextRepository: SimpleTextRepository

    fun getAllText(): List<String> {
       return simpleTextRepository.getAll()
    }

    fun delete( text: String ){
       return simpleTextRepository.delete(text)
    }

    fun addOrUpdateText(text: String){
        return simpleTextRepository.addOrUpdate(text)
    }
}
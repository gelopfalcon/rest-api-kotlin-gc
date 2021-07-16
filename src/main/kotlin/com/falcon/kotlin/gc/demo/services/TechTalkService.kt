package com.falcon.kotlin.gc.demo.services

import com.falcon.kotlin.gc.demo.dtos.TechTalkDto
import com.falcon.kotlin.gc.demo.models.TechTalk
import com.falcon.kotlin.gc.demo.repositories.TechTalkRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class TechTalkService(@Autowired
                      val repository: TechTalkRepository) {


    fun getTechTalks(): MutableIterable<TechTalk> {
        return repository.findAll();
    }

    fun createTechTalk(techTalkDto: TechTalkDto) {
        repository.save(techTalkDto.toTechTalk())

    }

    private fun TechTalkDto.toTechTalk() = TechTalk(
            name = "$name",
            date = "$date",
            id = UUID.randomUUID()
    )
}
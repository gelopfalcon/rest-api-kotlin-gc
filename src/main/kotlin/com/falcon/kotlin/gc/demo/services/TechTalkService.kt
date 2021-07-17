package com.falcon.kotlin.gc.demo.services

import com.falcon.kotlin.gc.demo.dtos.TechTalkDto
import com.falcon.kotlin.gc.demo.dtos.TechTalkResponseDto
import com.falcon.kotlin.gc.demo.models.TechTalk
import com.falcon.kotlin.gc.demo.repositories.TechTalkRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class TechTalkService(@Autowired
                      val repository: TechTalkRepository) {


    fun getTechTalks(): MutableList<TechTalkResponseDto> {
        return repository.findAll().map { techTalk -> techTalk.toTechTalkDto()  }.toMutableList()
    }

    fun createTechTalk(techTalkDto: TechTalkDto) : TechTalkResponseDto {
        var techTalk = repository.save(techTalkDto.toTechTalk())
        return techTalk.toTechTalkDto();

    }

    private fun TechTalkDto.toTechTalk() = TechTalk(
            name = name,
            date = date,
            id = UUID.randomUUID()
    )

    private fun TechTalk.toTechTalkDto() = TechTalkResponseDto(
            id = id,
            name = name,
            date = date,
    )
}
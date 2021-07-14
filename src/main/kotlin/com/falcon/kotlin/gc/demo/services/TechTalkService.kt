package com.falcon.kotlin.gc.demo.services

import com.falcon.kotlin.gc.demo.dtos.TechTalkDto
import org.springframework.stereotype.Service

@Service
class TechTalkService {

    fun getTechTalks() : MutableList<TechTalkDto> {
        val mutableList = mutableListOf<TechTalkDto>()
        mutableList.add(TechTalkDto("SonarQube", "14-07-2021"));
        return mutableList;
    }
}
package com.falcon.kotlin.gc.demo.controller

import com.falcon.kotlin.gc.demo.dtos.TechTalkDto
import com.falcon.kotlin.gc.demo.services.TechTalkService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("tech-talks")
class TechTalkController {
    @Autowired
    lateinit var techTalkService: TechTalkService

    @GetMapping
    fun getTechTalks() = techTalkService.getTechTalks();

    @PostMapping
    fun createTechTalk(@RequestBody techTalkDto: TechTalkDto) = techTalkService.createTechTalk(techTalkDto)

}
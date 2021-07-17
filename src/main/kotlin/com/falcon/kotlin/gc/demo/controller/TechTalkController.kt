package com.falcon.kotlin.gc.demo.controller

import com.falcon.kotlin.gc.demo.dtos.TechTalkDto
import com.falcon.kotlin.gc.demo.dtos.TechTalkResponseDto
import com.falcon.kotlin.gc.demo.services.TechTalkService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("tech-talks")
class TechTalkController {
    @Autowired
    lateinit var techTalkService: TechTalkService

    @GetMapping
    fun getTechTalks(): ResponseEntity<MutableList<TechTalkResponseDto>> =
            ResponseEntity(techTalkService.getTechTalks(), HttpStatus.OK);

    @PostMapping
    fun createTechTalk(@RequestBody techTalkDto: TechTalkDto) : ResponseEntity<TechTalkResponseDto>  =
         ResponseEntity(techTalkService.createTechTalk(techTalkDto), HttpStatus.CREATED)

    @GetMapping("/{id}")
    fun getTechTalk(@PathVariable("id") id: UUID){
        techTalkService.getTechTalkById(id)
    }
}
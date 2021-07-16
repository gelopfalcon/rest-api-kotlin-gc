package com.falcon.kotlin.gc.demo.repositories

import com.falcon.kotlin.gc.demo.models.TechTalk
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TechTalkRepository: CrudRepository<TechTalk, UUID> {
}
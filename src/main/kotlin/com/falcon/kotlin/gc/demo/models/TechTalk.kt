package com.falcon.kotlin.gc.demo.models

import java.util.*
import javax.persistence.*

@Entity(name = "tech_talks")
 data class TechTalk(
        @Id
        var id: UUID,
        @Column
        var name: String,
        @Column
        var date: String
        )


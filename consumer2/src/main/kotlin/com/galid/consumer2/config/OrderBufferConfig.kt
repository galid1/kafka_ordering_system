package com.galid.consumer2.config

import com.galid.consumer2.model.Message
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class OrderBufferConfig {
    @Bean
    fun priorityQueue(): PriorityQueue<Message> {
        return PriorityQueue(100)
    }
}
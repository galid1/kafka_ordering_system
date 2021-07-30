package com.galid.consumer1.config

import com.galid.consumer1.model.Message
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
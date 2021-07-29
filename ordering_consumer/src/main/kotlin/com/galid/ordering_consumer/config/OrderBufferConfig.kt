package com.galid.ordering_consumer.config

import com.galid.ordering_consumer.model.Message
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
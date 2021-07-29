package com.galid.ordering_consumer.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import com.galid.ordering_consumer.model.Message
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.function.Consumer

@Component
class OrderingConsumer(
    private val objectMapper: ObjectMapper,
    private val messageAppender: MessageAppender
) {

    @Bean
    fun consumeForOrder(): Consumer<String> {
         return Consumer {
             messageAppender.putToOrderBuffer(toMessageObject(it))
         }
    }

    internal fun toMessageObject(message: String): Message {
        return objectMapper.readValue(message, Message::class.java)
    }
}
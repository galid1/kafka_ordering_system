package com.galid.consumer2.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import com.galid.consumer2.model.Message
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.function.Consumer
import kotlin.random.Random

@Component
class OrderingConsumer(
    private val objectMapper: ObjectMapper,
    private val messageAppender: MessageAppender
) {

    @Bean
    fun consumeForOrder(): Consumer<String> {
         return Consumer {
             //validate
             Thread.sleep(Random.nextInt(10, 20).toLong())
             
             messageAppender.putToOrderBuffer(toMessageObject(it))
         }
    }

    internal fun toMessageObject(message: String): Message {
        return objectMapper.readValue(message, Message::class.java)
    }
}
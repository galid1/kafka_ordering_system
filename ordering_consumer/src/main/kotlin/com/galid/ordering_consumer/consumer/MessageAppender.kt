package com.galid.ordering_consumer.consumer

import com.galid.ordering_consumer.model.Message
import org.springframework.stereotype.Component
import java.util.*

@Component
class MessageAppender(
    private val orderBuffer: PriorityQueue<Message>
) {
    fun putToOrderBuffer(
        message: Message
    ) {
        orderBuffer.add(message)
    }
}
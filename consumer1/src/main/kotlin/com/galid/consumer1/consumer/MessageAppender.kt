package com.galid.consumer1.consumer

import com.galid.consumer1.model.Message
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
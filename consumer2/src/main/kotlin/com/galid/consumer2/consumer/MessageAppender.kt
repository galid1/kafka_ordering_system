package com.galid.consumer2.consumer

import com.galid.consumer2.model.Message
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
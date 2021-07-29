package com.galid.ordering_consumer.model

import java.time.LocalDateTime

class Message(
    val sequence: Long,
    val entryDate: LocalDateTime = LocalDateTime.now(),
): Comparable<Message> {
    override fun compareTo(other: Message): Int {
        return if (this.sequence > other.sequence)
            1
        else
            -1
    }
}
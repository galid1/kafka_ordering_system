package com.galid.ordering_consumer

import com.galid.ordering_consumer.model.Message
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*

class PriorityQueueTest {
    lateinit var priorityQueue: PriorityQueue<Any>

    @BeforeEach
    fun setUp() {
        priorityQueue = PriorityQueue()
    }

    @Test
    fun `우선순위 큐 테스트`() {
        // given
        val nums = listOf(1, 100, 10, 20, 5)

        for (num in nums) {
            priorityQueue.add(num)
        }

        // then
        val sortedNum = nums.sorted()

        for (num in sortedNum) {
            val pollValue = priorityQueue.poll()
            assertEquals(num, pollValue)
        }
    }

    @Test
    fun `message 우선순위 큐 테스트`() {
        // given
        // when
        val messages = listOf(
            Message(sequence = 1L),
            Message(sequence = 5L),
            Message(sequence = 3L),
            Message(sequence = 2L),
            Message(sequence = 4L),
        )
        priorityQueue.addAll(messages)

        // then
        val sortedMessage = messages.sorted()
        for (m in sortedMessage) {
            val pollM = priorityQueue.poll() as Message
            assertEquals(m, pollM)
        }
    }

}
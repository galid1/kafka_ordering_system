package com.galid.ordering_consumer.service

import com.galid.ordering_consumer.model.Message
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.Exception
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Service
class OrderingService(
    private val orderBuffer: PriorityQueue<Message>,
    private val sequenceService: SequenceService,
    private val entryService: EntryService
) {
    private val executes: ExecutorService = Executors.newFixedThreadPool(5)

    @Transactional
    fun sort() {
        executes.submit {
            while (true) {
                Thread.sleep(2000)
                val peek = orderBuffer.peek()

                if (peek?.sequence != sequenceService.getCurSequence()) {
                    continue
                }

                entryService.enter(orderBuffer.poll())
                sequenceService.increaseSequence()
            }
        }
    }
}
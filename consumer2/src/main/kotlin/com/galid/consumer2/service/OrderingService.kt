package com.galid.consumer2.service

import com.galid.consumer2.model.Message
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
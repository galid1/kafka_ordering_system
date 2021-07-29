package com.galid.binder_test.service

import com.galid.binder_test.model.Message
import com.galid.binder_test.producer.EntryRequestProducer
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Sinks
import java.time.LocalDateTime

@Service
class EntryService(
    private val entryRequestProducer: EntryRequestProducer,
    private val sequenceService: SequenceService
) {

    @Transactional
    fun enter() {
        val message = Message(
            sequence = sequenceService.getCurSequence().toString(),
            entryDate = LocalDateTime.now()
        )

        println("produce Message : ${message.sequence}")
        entryRequestProducer.sinker
            .emitNext(message, Sinks.EmitFailureHandler.FAIL_FAST)
    }
}
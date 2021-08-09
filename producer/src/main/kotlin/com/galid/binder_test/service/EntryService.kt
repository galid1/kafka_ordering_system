package com.galid.binder_test.service

import com.galid.binder_test.model.Message
import com.galid.binder_test.producer.EntryRequestProducer
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Sinks
import java.time.LocalDateTime

@Service
class EntryService(
    private val entryRequestProducer: EntryRequestProducer,
    private val sequenceService: SequenceService
) {

    fun enter(): String {
        return sequenceService.getCurSequence().toString()

//        val message = Message(
//            sequence = sequenceService.getCurSequence().toString(),
//            entryDate = LocalDateTime.now()
//        )
//
//        entryRequestProducer.sinker
//            .emitNext(message, Sinks.EmitFailureHandler.FAIL_FAST)
    }
}
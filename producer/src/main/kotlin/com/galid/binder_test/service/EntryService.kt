package com.galid.binder_test.service

import org.springframework.stereotype.Service

@Service
class EntryService(
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
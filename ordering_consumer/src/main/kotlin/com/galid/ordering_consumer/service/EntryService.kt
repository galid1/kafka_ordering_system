package com.galid.ordering_consumer.service

import com.galid.ordering_consumer.model.EntryEntity
import com.galid.ordering_consumer.model.EntryRepository
import com.galid.ordering_consumer.model.Message
import org.springframework.stereotype.Service

@Service
class EntryService(
    private val entryRepository: EntryRepository
) {
    fun enter(message: Message) {
        val entry = EntryEntity(
            entryDate = message.entryDate
        )

        entryRepository.save(entry)
    }
}
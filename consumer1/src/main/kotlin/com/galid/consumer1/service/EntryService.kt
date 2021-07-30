package com.galid.consumer1.service

import com.galid.consumer1.model.EntryEntity
import com.galid.consumer1.model.EntryRepository
import com.galid.consumer1.model.Message
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
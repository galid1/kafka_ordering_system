package com.galid.consumer2.service

import com.galid.consumer2.model.EntryEntity
import com.galid.consumer2.model.EntryRepository
import com.galid.consumer2.model.Message
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
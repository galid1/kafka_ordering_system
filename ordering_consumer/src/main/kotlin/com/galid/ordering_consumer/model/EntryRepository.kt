package com.galid.ordering_consumer.model

import org.springframework.data.jpa.repository.JpaRepository

interface EntryRepository: JpaRepository<EntryEntity, Long>{
}
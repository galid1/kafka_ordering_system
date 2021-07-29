package com.galid.consumer2

import org.springframework.data.jpa.repository.JpaRepository

interface EntryRepository: JpaRepository<EntryEntity, Long> {
}
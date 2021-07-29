package com.galid.consumer_test

import org.springframework.data.jpa.repository.JpaRepository

interface EntryRepository: JpaRepository<EntryEntity, Long> {
}
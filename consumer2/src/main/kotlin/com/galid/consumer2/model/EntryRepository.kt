package com.galid.consumer2.model

import org.springframework.data.jpa.repository.JpaRepository

interface EntryRepository: JpaRepository<EntryEntity, Long>{
}
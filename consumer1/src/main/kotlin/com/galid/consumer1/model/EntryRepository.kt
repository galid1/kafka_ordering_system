package com.galid.consumer1.model

import org.springframework.data.jpa.repository.JpaRepository

interface EntryRepository: JpaRepository<EntryEntity, Long>{
}
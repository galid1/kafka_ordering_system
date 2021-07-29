package com.galid.consumer_test

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.function.Consumer
import kotlin.random.Random


@Component
class TestConsumer(
    private val entryRepository: EntryRepository
) {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    @Bean
    fun testC(): Consumer<String> {
        return Consumer {
            Thread.sleep(Random.nextInt(10, 300).toLong())
            entryRepository.save(
                EntryEntity(
                    entryDate = LocalDateTime.parse(it, formatter),
                    createdBy = "CONSUMER_1"
                )
            )
        }

    }
}
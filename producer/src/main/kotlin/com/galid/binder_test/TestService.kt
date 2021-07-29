package com.galid.binder_test

import org.springframework.stereotype.Service
import reactor.core.publisher.Sinks
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter




@Service
class TestService(
    private val testProducer: TestProducer
) {
    var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    fun enter() {
        val now = LocalDateTime.now().format(formatter)
        print("?NOW: ${now}")

        testProducer.sinker
            .emitNext(now.toString(), Sinks.EmitFailureHandler.FAIL_FAST)
    }
}
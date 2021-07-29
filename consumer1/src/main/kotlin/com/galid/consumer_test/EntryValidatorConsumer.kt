package com.galid.consumer_test

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import reactor.core.publisher.Sinks
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.function.Consumer
import kotlin.random.Random


@Component
class EntryValidatorConsumer(
    private val orderRequestProducer: OrderRequestProducer
) {

    @Bean
    fun consumeForValidate(): Consumer<String> {
        return Consumer {
            // 검증 작업 대신
            Thread.sleep(Random.nextInt(10, 300).toLong())

            println("OK !")
            orderRequestProducer.sinker
                .emitNext(it, Sinks.EmitFailureHandler.FAIL_FAST)
        }
    }
}
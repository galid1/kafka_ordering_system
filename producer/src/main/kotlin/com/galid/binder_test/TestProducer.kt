package com.galid.binder_test

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import reactor.core.publisher.EmitterProcessor
import reactor.core.publisher.Flux
import reactor.core.publisher.Sinks
import java.util.function.Supplier


@Component
class TestProducer {
    val sinker = Sinks.many().unicast().onBackpressureBuffer<String>()

    @Bean
    fun testP(): Supplier<Flux<String>> {
        return Supplier {
            sinker.asFlux()
        }
    }

//    @Bean
//    fun testP(): Supplier<String> {
//        return Supplier {
//                "aaaa"
//        }
//    }
}
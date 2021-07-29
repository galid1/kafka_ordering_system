package com.galid.consumer2

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Sinks
import java.util.function.Supplier

@Component
class OrderRequestProducer {
    val sinker = Sinks.many().unicast().onBackpressureBuffer<String>()

    @Bean
    fun requestOrdering(): Supplier<Flux<String>> {
        return Supplier {
            sinker.asFlux()
        }
    }
}
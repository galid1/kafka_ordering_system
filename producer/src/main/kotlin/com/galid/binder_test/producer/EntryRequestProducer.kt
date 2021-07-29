package com.galid.binder_test.producer

import com.galid.binder_test.model.Message
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Sinks
import java.util.function.Supplier

@Component
class EntryRequestProducer {
    val sinker = Sinks.many().unicast().onBackpressureBuffer<Message>()

    @Bean
    fun entryProducer(): Supplier<Flux<Message>> {
        return Supplier {
            sinker.asFlux()
        }
    }
}
package com.galid.binder_test

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.EmitterProcessor
import reactor.core.publisher.Flux
import reactor.core.publisher.Sinks
import java.util.function.Supplier

@RestController
class TestController(
    private val testService: TestService
) {
    @GetMapping("/")
    fun enter() {
        testService.enter()
    }
}
package com.galid.ordering_consumer

import com.galid.ordering_consumer.service.OrderingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    private val orderingService: OrderingService
) {
    @GetMapping
    fun tet() {
        orderingService.sort()
    }
}
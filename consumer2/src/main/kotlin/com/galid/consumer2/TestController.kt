package com.galid.consumer2

import com.galid.consumer2.service.OrderingService
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
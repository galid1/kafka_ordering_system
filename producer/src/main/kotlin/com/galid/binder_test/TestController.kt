package com.galid.binder_test

import com.galid.binder_test.service.EntryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    private val entryService: EntryService
) {
    @GetMapping("/")
    fun enter() {
        entryService.enter()
    }
}
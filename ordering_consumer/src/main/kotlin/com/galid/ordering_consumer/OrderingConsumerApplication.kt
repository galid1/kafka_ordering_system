package com.galid.ordering_consumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OrderingConsumerApplication

fun main(args: Array<String>) {
	runApplication<OrderingConsumerApplication>(*args)
}

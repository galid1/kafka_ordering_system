package com.galid.consumer1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Consumer1Application

fun main(args: Array<String>) {
	runApplication<Consumer1Application>(*args)
}

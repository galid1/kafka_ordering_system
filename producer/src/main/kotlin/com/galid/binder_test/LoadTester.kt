package com.galid.binder_test

import org.slf4j.LoggerFactory
import org.springframework.util.StopWatch
import org.springframework.web.client.RestTemplate
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

class LoadTester {
}

val logger = LoggerFactory.getLogger(LoadTester::class.java)
val counter = AtomicInteger(0)

fun main() {
    val es = Executors.newFixedThreadPool(100)

    val rt = RestTemplate()
    val url = "http://localhost:8080/"

    val main = StopWatch()
    main.start()

    for (i in 0 .. 10000) {
        es.execute {
            val idx = counter.addAndGet(1)
            logger.info("Thread $idx")

            val sw = StopWatch()
            sw.start()

            rt.getForObject(url, String::class.java)

            sw.stop()
            logger.info("Elapsed : ${idx} ${sw.totalTimeSeconds}")
        }
    }

    es.shutdown()
    es.awaitTermination(100, TimeUnit.SECONDS)

    main.stop()
    logger.info("Total ${main.totalTimeSeconds}")
}

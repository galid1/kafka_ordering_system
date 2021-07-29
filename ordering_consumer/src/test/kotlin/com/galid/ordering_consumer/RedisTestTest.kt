package com.galid.ordering_consumer

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.redis.core.RedisTemplate

@SpringBootTest
internal class RedisTestTest {

    @Autowired
    lateinit var redisTemplate: RedisTemplate<String, String>

    @Test
    fun `test redis`() {
        // given
        val sequence = redisTemplate.opsForValue()
            .set("sequence", "1")

        // when
        for (i in 0..9) {
            redisTemplate.opsForValue()
                .increment("sequence", 1L)
        }

        // then
        assertEquals(
            11L.toString(),
            redisTemplate.opsForValue()
            .get("sequence")!!
        )
    }

}
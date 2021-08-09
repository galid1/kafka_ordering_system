package com.galid.binder_test.service

import org.springframework.beans.factory.InitializingBean
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
class SequenceService(
    private val redisTemplate: RedisTemplate<String, String>
): InitializingBean {
    fun getCurSequence(): Long {
        return redisTemplate.opsForValue()
            .increment(SEQUENCE_KEY, 1L)!!
            .toLong()
    }

    companion object {
        const val SEQUENCE_KEY = "producer_sequence"
    }

    override fun afterPropertiesSet() {
        redisTemplate.opsForValue()
            .get(SEQUENCE_KEY)
            ?: run {
                redisTemplate.opsForValue()
                    .set(SEQUENCE_KEY, "0")
            }
    }
}
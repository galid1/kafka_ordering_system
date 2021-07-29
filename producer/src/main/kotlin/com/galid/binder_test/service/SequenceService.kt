package com.galid.binder_test.service

import org.springframework.beans.factory.InitializingBean
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
class SequenceService(
    private val redisTemplate: RedisTemplate<String, String>
): InitializingBean {
    fun getCurSequence(): Long {
        val curSequence = redisTemplate.opsForValue()
            .get(SEQUENCE_KEY)!!
            .toLong()

        increaseSequence()

        return curSequence
    }

    internal fun increaseSequence() {
        redisTemplate.opsForValue()
            .increment(SEQUENCE_KEY, 1L)
    }

    companion object {
        const val SEQUENCE_KEY = "producer_sequence"
    }

    override fun afterPropertiesSet() {
        redisTemplate.opsForValue()
            .get(SEQUENCE_KEY)
            ?: run {
                redisTemplate.opsForValue()
                    .set(SEQUENCE_KEY, "1")
            }
    }
}
package com.galid.binder_test.service

import com.galid.binder_test.model.Sequence
import com.galid.binder_test.repository.SequenceRepository
import org.bson.types.ObjectId
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Service

@Service
class SequenceService(
//    private val redisTemplate: RedisTemplate<String, String>
    private val sequenceRepository: SequenceRepository
): InitializingBean {
    var sequenceId: ObjectId? = null

    fun getCurSequence(): Long {
        return sequenceRepository.incSequence(sequenceId!!)
    }

    companion object {
        const val SEQUENCE_KEY = "producer_sequence"
    }

    override fun afterPropertiesSet() {
        val sequence = sequenceRepository.save(Sequence(sequence = 0))
        sequenceId = sequence.id
    }
}
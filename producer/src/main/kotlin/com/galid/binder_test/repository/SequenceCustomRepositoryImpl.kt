package com.galid.binder_test.repository

import com.galid.binder_test.model.Sequence
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.findAndModify
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update

class SequenceCustomRepositoryImpl(
    private val mongoTemplate: MongoTemplate
): SequenceCustomRepository {
    override fun incSequence(sequenceId: ObjectId): Long {
        val query = Query(Criteria("_id").`is`(sequenceId))
        val update = Update().inc("sequence", 1)
        return mongoTemplate.findAndModify(query, update, Sequence::class.java)!!.sequence

    }
}
package com.galid.binder_test.repository

import com.galid.binder_test.model.Sequence
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface SequenceRepository: MongoRepository<Sequence, ObjectId>, SequenceCustomRepository{
}
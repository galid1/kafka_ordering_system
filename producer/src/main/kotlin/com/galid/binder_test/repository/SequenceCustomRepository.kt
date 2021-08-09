package com.galid.binder_test.repository

import org.bson.types.ObjectId

interface SequenceCustomRepository {
    fun incSequence(id: ObjectId): Long
}
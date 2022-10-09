package dev.jimboslice.data.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class Course(
    @BsonId
    val id: String = ObjectId().toString()
)

package dev.jimboslice.data

import dev.jimboslice.GeoPoint
import dev.jimboslice.data.model.Course
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.MongoOperator.nearSphere
import org.litote.kmongo.MongoOperator.geometry

class CourseDataSourceImpl(
    private val db: CoroutineDatabase
): CourseDataSource {

    private val courses = db.getCollection<Course>()

    override suspend fun getCoursesByLocation(geoPoint: GeoPoint, distance: Double): List<Course> {
        return courses.find("{ location: { $nearSphere : { $geometry: { type: \"Point\", coordinates: [ ${geoPoint.longitude}, ${geoPoint.latitude} ] }, \$maxDistance: $distance } } }").toList()
    }

    override suspend fun getCourse(id: String): Course? {
        return courses.findOneById(id)
    }
}
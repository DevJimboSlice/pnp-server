package dev.jimboslice.data

import dev.jimboslice.GeoPoint
import dev.jimboslice.data.model.Course

interface CourseDataSource {

    /**
     * @param distance Distance from GeoPoint in meters
     */
    suspend fun getCoursesByLocation(geoPoint: GeoPoint, distance: Double): List<Course>

    suspend fun getCourse(id: String): Course?
}
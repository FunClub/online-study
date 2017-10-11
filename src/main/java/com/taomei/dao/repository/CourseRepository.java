package com.taomei.dao.repository;

import com.taomei.dao.docment.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course,String> {
}

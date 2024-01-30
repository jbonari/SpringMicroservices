package com.microservice.course.repository;

import com.microservice.course.entitites.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IcourseRepository extends CrudRepository<Course,Long> {
}

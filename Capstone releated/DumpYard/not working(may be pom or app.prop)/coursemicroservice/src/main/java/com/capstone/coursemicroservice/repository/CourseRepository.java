package com.capstone.coursemicroservice.repository;


import com.capstone.coursemicroservice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}

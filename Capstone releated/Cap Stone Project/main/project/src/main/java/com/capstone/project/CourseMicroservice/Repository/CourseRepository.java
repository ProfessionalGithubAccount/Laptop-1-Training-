package com.capstone.project.CourseMicroservice.Repository;

import java.util.List;

import com.capstone.project.CourseMicroservice.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findTop5ByOrderByIdDesc();  
}
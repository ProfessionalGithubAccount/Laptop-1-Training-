package com.capstone.project.CourseMicroservice.Service;

import java.util.List;

import com.capstone.project.CourseMicroservice.Entity.Course;
import com.capstone.project.CourseMicroservice.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AssignmentMicroservice.Entity.Assignment;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> getRecentCourses() {
        return courseRepository.findTop5ByOrderByIdDesc();
    }

    public List<Integer> getEachAssignmentScore(Long courseId) {
        Course course = courseRepository.findById(courseId).orElse(null);
        if (course != null) {
            return course.getAssignments().stream().map(Assignment::getMark).toList();
        }
        return List.of();
    }
}

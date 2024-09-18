package com.capstone.coursemicroservice.controller;


import com.capstone.coursemicroservice.entity.Course;
import com.capstone.coursemicroservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable Integer courseId) {
        return courseService.getCourseById(courseId);
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @PutMapping
    public Course updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }

//    @DeleteMapping("/{courseId}")
//    public void deleteCourse(@PathVariable Integer courseId) {
//        courseService.deleteCourse(courseId);
//    }

    @GetMapping("/recent")
    public List<Course> getRecentCourses() {
        return courseService.getRecentCourses();
    }

//    @GetMapping("/{courseId}/professor")
//    public String getProfessorName(@PathVariable Integer courseId) {
//        Course course = courseService.getCourseById(courseId);
//        return courseService.getProfessorNameById(course.getProfessorId());
//    }

    @GetMapping("/{courseId}/assignments")
    public List<Course> getCoursesWithAssignments(@PathVariable Integer courseId) {
        return courseService.getCoursesWithAssignments();
    }
}

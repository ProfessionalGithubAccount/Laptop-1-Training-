package com.capstoneproject.coursemicroservice.controller;

import com.capstoneproject.coursemicroservice.entity.Course;
import com.capstoneproject.coursemicroservice.service.CourseService;
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

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }
}

//import com.capstoneproject.coursemicroservice.entity.Course;
//import com.capstoneproject.coursemicroservice.service.CourseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/courses")
//public class CourseController {
//
//    @Autowired
//    private CourseService courseService;
//
//    @GetMapping
//    public List<Course> getAllCourses() {
//        return courseService.getAllCourses();
//    }
//
//    @GetMapping("/{id}")
//    public Course getCourseById(@PathVariable Long id) {
//        return courseService.getCourseById(id);
//    }
//
//    @PostMapping
//    public Course createCourse(@RequestBody Course course) {
//        return courseService.saveCourse(course);
//    }
//}
//

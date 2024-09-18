package com.capstone.project.CourseMicroservice.Controller;

import java.util.List;

import com.capstone.project.CourseMicroservice.Entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.project.CourseMicroservice.Service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/greetCourses")
    public String greetCourses(){
        return "Hello Courses";
    }

    @GetMapping("/getAllCourses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/recent")
    public List<Course> getRecentCourses() {
        return courseService.getRecentCourses();
    }

    @GetMapping("/{courseId}/visualize")
    public List<Integer> getEachAssignmentScore(@PathVariable Long courseId) {
        return courseService.getEachAssignmentScore(courseId);
    }
}

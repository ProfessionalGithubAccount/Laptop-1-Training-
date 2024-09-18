package com.capstoneproject.coursemicroservice.service;

import com.capstoneproject.coursemicroservice.entity.Course;
import com.capstoneproject.coursemicroservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long courseId) {
        Course course = courseRepository.findById(courseId).orElse(null);
        if (course != null) {
            //List<Long> assignmentIds = restTemplate.getForObject("http://assignment-service/assignments/course/" + courseId + "/ids", List.class);
            List<Long> assignmentIds = restTemplate.getForObject("http://localhost:5001/assignments/course/" + courseId + "/ids", List.class);

            course.setAssignmentIds(assignmentIds);
        }
        return course;
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
}

//
//
//import com.capstoneproject.coursemicroservice.entity.Course;
//import com.capstoneproject.coursemicroservice.repository.CourseRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CourseService {
//
//    @Autowired
//    private CourseRepository courseRepository;
//
//    public List<Course> getAllCourses() {
//        return courseRepository.findAll();
//    }
//
//    public Course getCourseById(Long courseId) {
//        return courseRepository.findById(courseId).orElse(null);
//    }
//
//    public Course saveCourse(Course course) {
//        return courseRepository.save(course);
//    }
//}
//
//import com.capstoneproject.coursemicroservice.entity.Course;
//import com.capstoneproject.coursemicroservice.repository.CourseRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//
//@Service
//public class CourseService {
//
//    @Autowired
//    private CourseRepository courseRepository;
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    public List<Course> getAllCourses() {
//        return courseRepository.findAll();
//    }
//
////    public Course getCourseById(Long courseId) {
////        Course course = courseRepository.findById(courseId).orElse(null);
////        if (course != null) {
////            List<Assignment> assignments = restTemplate.getForObject("http://assignment-service/assignments/course/" + courseId, List.class);
////            // Attach assignments to course if needed
////        }
////        return course;
////    }
//
//    public Course saveCourse(Course course) {
//        return courseRepository.save(course);
//    }
//}



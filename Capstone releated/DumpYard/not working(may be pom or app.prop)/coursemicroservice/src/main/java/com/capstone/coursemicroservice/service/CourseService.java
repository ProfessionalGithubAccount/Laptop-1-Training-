package com.capstone.coursemicroservice.service;

import com.capstone.coursemicroservice.entity.Course;
import com.capstone.coursemicroservice.repository.CourseRepository;
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

    public Course getCourseById(Integer courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

//    public void deleteCourse(Integer courseId) {
//        courseRepository.deleteById(courseId);
//    }

    public List<Course> getRecentCourses() {
        // Dummy implementation, adjust based on real requirements
        return courseRepository.findAll(); // Fetch all courses for now
    }

//    public String getProfessorNameById(Integer professorId) {
//        String url = "http://professor-service/professors/" + professorId;
//        return restTemplate.getForObject(url, String.class);
//    }

    public List<Course> getCoursesWithAssignments() {
        // Fetch courses and include assignment details
        // This would ideally involve calling the Assignments microservice
        return courseRepository.findAll(); // Placeholder
    }
}

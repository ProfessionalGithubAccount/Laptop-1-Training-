package com.capstone.assignmentmicroservice.repository;

import com.capstone.assignmentmicroservice.entity.StudentAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseMarksRepository extends JpaRepository<StudentAssignment, Integer> {

    // Custom query method to find a record by studentId and courseId
    StudentAssignment findByStudentIdAndCourseId(Integer studentId, Integer courseId);
}

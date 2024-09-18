package com.capstone.assignment.repository;

import com.capstone.assignment.entity.StudentAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAssignmentRepository extends JpaRepository<StudentAssignment, Integer> {
    StudentAssignment findByStudentIdAndCourseId(Integer studentId, Integer courseId);
}

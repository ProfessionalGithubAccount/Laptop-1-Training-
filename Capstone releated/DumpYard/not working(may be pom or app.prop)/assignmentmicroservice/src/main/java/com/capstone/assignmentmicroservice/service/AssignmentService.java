package com.capstone.assignmentmicroservice.service;


import com.capstone.assignmentmicroservice.entity.Assignment;
import com.capstone.assignmentmicroservice.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public Assignment getAssignmentById(Integer assignmentId) {
        return assignmentRepository.findById(assignmentId).orElse(null);
    }

    public List<Assignment> getAssignmentsByCourseId(Integer courseId) {
        return assignmentRepository.findByCourseId(courseId);
    }

    public Assignment saveAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public Assignment updateAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public void deleteAssignment(Integer assignmentId) {
        assignmentRepository.deleteById(assignmentId);
    }

    public List<Assignment> getDeadlines() {
        List<Assignment> assignments = assignmentRepository.findAll();
        assignments.sort((a1, a2) -> a1.getDeadline().compareTo(a2.getDeadline()));
        return assignments;
    }
}

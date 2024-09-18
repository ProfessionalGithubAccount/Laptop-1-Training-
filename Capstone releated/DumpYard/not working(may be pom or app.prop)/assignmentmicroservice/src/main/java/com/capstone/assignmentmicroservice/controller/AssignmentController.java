package com.capstone.assignmentmicroservice.controller;

import com.capstone.assignmentmicroservice.entity.Assignment;
import com.capstone.assignmentmicroservice.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {
    @Autowired
    private AssignmentService assignmentService;

    @GetMapping
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    @GetMapping("/{assignmentId}")
    public Assignment getAssignmentById(@PathVariable Integer assignmentId) {
        return assignmentService.getAssignmentById(assignmentId);
    }

    @GetMapping("/course/{courseId}")
    public List<Assignment> getAssignmentsByCourseId(@PathVariable Integer courseId) {
        return assignmentService.getAssignmentsByCourseId(courseId);
    }

    @PostMapping
    public String uploadAssignment(@RequestBody Assignment assignment) {
        assignmentService.saveAssignment(assignment);
        return "Assignment uploaded successfully.";
    }

    @PutMapping
    public Assignment updateAssignment(@RequestBody Assignment assignment) {
        return assignmentService.updateAssignment(assignment);
    }

    @DeleteMapping("/{assignmentId}")
    public void deleteAssignment(@PathVariable Integer assignmentId) {
        assignmentService.deleteAssignment(assignmentId);
    }

    @GetMapping("/deadlines")
    public List<Assignment> getDeadlines() {
        return assignmentService.getDeadlines();
    }

    @GetMapping("/files")
    public List<String> getFilesSubmitted() {
        List<Assignment> assignments = assignmentService.getAllAssignments();
        return assignments.stream().map(Assignment::getFileName).toList();
    }
}

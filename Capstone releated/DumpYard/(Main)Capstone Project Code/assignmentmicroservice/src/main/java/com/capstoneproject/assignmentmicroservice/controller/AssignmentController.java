package com.capstoneproject.assignmentmicroservice.controller;

import com.capstoneproject.assignmentmicroservice.entity.Assignment;
import com.capstoneproject.assignmentmicroservice.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @GetMapping("/course/{courseId}/ids")
    public List<Long> getAllAssignmentsIdsByCourseId(@PathVariable Long courseId) {
        return assignmentService.getAllAssignmentsIdsByCourseId(courseId);
    }
}

//
//@RestController
//@RequestMapping("/assignments")
//public class AssignmentController {
//
//    @Autowired
//    private AssignmentService assignmentService;
//
//    @GetMapping("/course/{courseId}")
//    public List<Assignment> getAssignmentsByCourseId(@PathVariable Long courseId) {
//        return assignmentService.getAssignmentsByCourseId(courseId);
//    }
//
//    @PostMapping
//    public Assignment createAssignment(@RequestBody Assignment assignment) {
//        return assignmentService.saveAssignment(assignment);
//    }
//}

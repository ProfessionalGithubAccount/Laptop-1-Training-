package com.capstoneproject.assignmentmicroservice.service;


import com.capstoneproject.assignmentmicroservice.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;



@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public List<Long> getAllAssignmentsIdsByCourseId(Long courseId) {
        return assignmentRepository.findByCourseId(courseId)
                .stream()
                .map(assignment -> assignment.getAssignmentId())
                .collect(Collectors.toList());
    }
}

//@Service
//public class AssignmentService {
//
//    @Autowired
//    private AssignmentRepository assignmentRepository;
//
//    public List<Long> getAllAssignmentsIdsByCourseId(Long courseId) {
//        return assignmentRepository.findByCourseId(courseId)
//                .stream()
//                .map(assignment -> assignment.getAssignmentId())
//                .collect(Collectors.toList());
//    }
//}


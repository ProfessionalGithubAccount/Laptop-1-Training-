package com.capstone.assignment.controller;

import com.capstone.assignment.entity.StudentAssignment;
import com.capstone.assignment.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @GetMapping("/showAll")
    public ResponseEntity<List<Map<String, Object>>> getAllAssignments() {
        return ResponseEntity.ok(assignmentService.getAllAssignments());
    }

    @GetMapping("/byCourseId/{courseId}")
    public ResponseEntity<List<Map<String, Object>>> getAssignmentsByCourseId(@PathVariable Integer courseId) {
        return ResponseEntity.ok(assignmentService.getAssignmentsByCourseId(courseId));
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadAssignment(@RequestParam("file") MultipartFile file,
                                                   @RequestParam("title") String title,
                                                   @RequestParam("id") Integer id,
                                                   @RequestParam("courseId") Integer courseId) {
        try {
            assignmentService.saveAssignment(file, title, id, courseId);
            return ResponseEntity.ok("Assignment uploaded successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload assignment: " + e.getMessage());
        }
    }

    @GetMapping("/showAssignmentFileById/{id}")
    public ResponseEntity<Resource> showAssignmentFileById(@PathVariable Integer id) {
        byte[] fileData = assignmentService.showAssignmentFileById(id);
        if (fileData == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        ByteArrayResource resource = new ByteArrayResource(fileData);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"assignment_" + id + ".pdf\"")
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(fileData.length)
                .body(resource);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Integer id) {
        byte[] fileData = assignmentService.showAssignmentFileById(id);
        if (fileData == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        ByteArrayResource resource = new ByteArrayResource(fileData);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"assignment_" + id + ".pdf\"")
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(fileData.length)
                .body(resource);
    }

    @PostMapping("/marks")
    public ResponseEntity<StudentAssignment> saveMarks(@RequestParam Integer studentId,
                                                       @RequestParam Integer courseId,
                                                       @RequestParam List<Integer> marks) {
        StudentAssignment savedMarks = assignmentService.saveStudentMarks(studentId, courseId, marks);
        return ResponseEntity.ok(savedMarks);
    }

    @GetMapping("/marks/{courseId}/{studentId}")
    public ResponseEntity<List<Integer>> getStudentAssignmentMarks(@PathVariable Integer studentId,
                                                                   @PathVariable Integer courseId) {
        List<Integer> marks = assignmentService.getStudentAssignmentMarks(studentId, courseId);
        return ResponseEntity.ok(marks);
    }
}

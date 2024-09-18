package com.capstone.assignment.service;

import com.capstone.assignment.entity.Assignment;
import com.capstone.assignment.entity.StudentAssignment;
import com.capstone.assignment.repository.AssignmentRepository;
import com.capstone.assignment.repository.StudentAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssignmentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private StudentAssignmentRepository studentCourseMarksRepository;

    public List<Map<String, Object>> getAllAssignments() {
        String sql = "SELECT assignment_id, professor_id, course_id, title, deadline, file_name FROM assignment";
        return jdbcTemplate.queryForList(sql);
    }

    public byte[] showAssignmentFileById(Integer id) {
        Optional<Assignment> assignment = assignmentRepository.findById(id);
        return assignment.map(Assignment::getAssignmentFile).orElse(null);
    }

    public List<Map<String, Object>> getAssignmentsByCourseId(Integer courseId) {
        String sql = "SELECT assignment_id, professor_id, title, deadline, file_name FROM assignment WHERE course_id = ?";
        return jdbcTemplate.queryForList(sql, courseId);
    }

    public List<Integer> getStudentAssignmentMarks(Integer studentId, Integer courseId) {
        StudentAssignment studentAssignment = studentCourseMarksRepository.findByStudentIdAndCourseId(studentId, courseId);
        if (studentAssignment == null || studentAssignment.getMarks().isEmpty()) {
            throw new IllegalArgumentException("No marks found for student " + studentId + " in course " + courseId);
        }
        return studentAssignment.getMarks();
    }

    public StudentAssignment saveStudentMarks(Integer studentId, Integer courseId, List<Integer> marks) {
        StudentAssignment studentAssignment = studentCourseMarksRepository.findByStudentIdAndCourseId(studentId, courseId);
        if (studentAssignment == null) {
            studentAssignment = new StudentAssignment();
            studentAssignment.setStudentId(studentId);
            studentAssignment.setCourseId(courseId);
        }
        studentAssignment.setMarks(marks);
        return studentCourseMarksRepository.save(studentAssignment);
    }

    public void saveAssignment(MultipartFile file, String title, Integer id, Integer courseId) throws IOException {
        Assignment assignment = new Assignment();
        assignment.setTitle(title);
        assignment.setAssignmentId(id);
        assignment.setCourseId(courseId);
        assignment.setFileName(file.getOriginalFilename());
        assignment.setAssignmentFile(file.getBytes());

        saveFileToLocalDirectory(file);
        assignmentRepository.save(assignment);
    }

    private void saveFileToLocalDirectory(MultipartFile file) throws IOException {
        String localDirectoryPath = "C:/uploads/"; // Change this to your desired path
        File localFile = new File(localDirectoryPath + file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(localFile)) {
            fos.write(file.getBytes());
        }
    }
}

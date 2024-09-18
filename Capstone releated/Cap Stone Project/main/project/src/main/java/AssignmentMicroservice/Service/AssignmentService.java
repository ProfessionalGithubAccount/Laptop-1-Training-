package AssignmentMicroservice.Service;

import java.util.List;

import AssignmentMicroservice.Entity.Assignment;
import AssignmentMicroservice.Repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public Assignment uploadAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public Assignment displayAssignment(Long assignmentId) {
        return assignmentRepository.findById(assignmentId).orElse(null);
    }

    public void deleteAssignment(Long assignmentId) {
        assignmentRepository.deleteById(assignmentId);
    }

    public String getDeadline(Long assignmentId) {
        Assignment assignment = assignmentRepository.findById(assignmentId).orElse(null);
        return assignment != null ? assignment.getDueDate().toString() : "Assignment not found";
    }

    public int getScore(Long assignmentId) {
        Assignment assignment = assignmentRepository.findById(assignmentId).orElse(null);
        return assignment != null ? assignment.getMark() : 0;
    }

    public String getSubmissionStatus(Long assignmentId) {
        // Implement logic to check submission status
        return "Submitted";  // Placeholder value
    }

    public List<String> filesSubmitted(Long assignmentId) {
        // Implement logic to retrieve list of files submitted
        return List.of("file1.docx", "file2.pdf");  // Placeholder values
    }
}

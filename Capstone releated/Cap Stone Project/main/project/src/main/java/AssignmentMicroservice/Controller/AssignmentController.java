package AssignmentMicroservice.Controller;

import java.util.List;

import AssignmentMicroservice.Entity.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import AssignmentMicroservice.Service.AssignmentService;

@RestController("/api/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @GetMapping("/greetAssignments")
    public String greetAssignments(){
        return "Hello Assignments";
    }

    @PostMapping
    public Assignment uploadAssignment(@RequestBody Assignment assignment) {
        return assignmentService.uploadAssignment(assignment);
    }

    @GetMapping("/{assignmentId}")
    public Assignment displayAssignment(@PathVariable Long assignmentId) {
        return assignmentService.displayAssignment(assignmentId);
    }

    @DeleteMapping("/{assignmentId}")
    public void deleteAssignment(@PathVariable Long assignmentId) {
        assignmentService.deleteAssignment(assignmentId);
    }

    @GetMapping("/{assignmentId}/deadline")
    public String getDeadline(@PathVariable Long assignmentId) {
        return assignmentService.getDeadline(assignmentId);
    }

    @GetMapping("/{assignmentId}/score")
    public int getScore(@PathVariable Long assignmentId) {
        return assignmentService.getScore(assignmentId);
    }

    @GetMapping("/{assignmentId}/status")
    public String getSubmissionStatus(@PathVariable Long assignmentId) {
        return assignmentService.getSubmissionStatus(assignmentId);
    }

    @GetMapping("/{assignmentId}/files")
    public List<String> filesSubmitted(@PathVariable Long assignmentId) {
        return assignmentService.filesSubmitted(assignmentId);
    }
}

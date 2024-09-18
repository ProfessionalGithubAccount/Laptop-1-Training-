package AssignmentMicroservice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.capstone.project.CourseMicroservice.Entity.Course;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Assignment {
 
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long assignmentId;

	    @ManyToOne
	    @JoinColumn(name = "course_id", nullable = false)
	    private Course course;  // This links to the Course entity and the course_id column in the database

	    private String title;

	    private String description;

	    @Temporal(TemporalType.DATE)
	    private Date dueDate;

	    private int mark = 0;
}

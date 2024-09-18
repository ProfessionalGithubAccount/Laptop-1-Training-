package AssignmentMicroservice.Repository;

import AssignmentMicroservice.Entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
}

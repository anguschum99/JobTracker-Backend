package angus.JobTracker.repo;

import angus.JobTracker.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobRepo extends JpaRepository<Job, Long> {

    void deleteJobById(Long id);

    Optional<Job> findJobById(Long id);
}

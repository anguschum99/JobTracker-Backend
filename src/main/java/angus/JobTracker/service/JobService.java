package angus.JobTracker.service;

import angus.JobTracker.exception.UserNotFoundException;
import angus.JobTracker.model.Job;
import angus.JobTracker.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JobService {
    private final JobRepo jobRepo;

    @Autowired
    public JobService(JobRepo jobRepo){
        this.jobRepo = jobRepo;
    }

    public Job addJob(Job job){
        // Let the database auto-generate the ID
        return jobRepo.save(job);
    }

    public List<Job> findAllJobs(){
        return jobRepo.findAll();
    }

    public Job updateJob(Job job){
        return jobRepo.save(job);
    }

    public void deleteJob(Long id){
        jobRepo.deleteJobById(id);
    }

    public Job findJobById(Long id){
        return jobRepo.findJobById(id).orElseThrow(() -> new UserNotFoundException("User by id" + id + " not found"));
    }

}

package angus.JobTracker;

import angus.JobTracker.exception.ResourceNotFoundException;
import angus.JobTracker.model.Job;
import angus.JobTracker.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobResource {
    private final JobService jobService;

    public JobResource(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Job>> getAllJobs(){
        List<Job> jobs = jobService.findAllJobs();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable("id") Long id){
        Job job = jobService.findJobById(id);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Job> addJob(@RequestBody Job job){
        Job newJob = jobService.addJob(job);
        return new ResponseEntity<>(newJob,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Job> updateJob(@RequestBody Job job){
        Job updateJob = jobService.updateJob(job);
        return new ResponseEntity<>(updateJob,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable("id") Long id) {
        try {
            jobService.deleteJob(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

package com.incognito.jobapp.job;


import com.incognito.jobapp.company.Company;
import com.incognito.jobapp.company.CompanyService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable  Long id){
        Job job = jobService.getJobById(id);
        if(Objects.isNull(job)){
            return new ResponseEntity<>(new Job(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean isDelete = jobService.deleteJobById(id);
        if (isDelete) return new ResponseEntity<>(
                "Job deleted successfully", HttpStatus.OK
        );
        else return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable long id, @RequestBody Job job){
        boolean isUpdate = jobService.updateJob(id, job);
        if(isUpdate) return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        else return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
    }
}

package com.incognito.jobapp.job.impl;

import com.incognito.jobapp.job.Job;
import com.incognito.jobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobs.stream().filter(j -> j.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        return jobs.removeIf(j -> j.getId().equals(id));
    }

    @Override
    public boolean updateJob(long id, Job updatedJob) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                return true;
            }
        }
        return false;
    }
}

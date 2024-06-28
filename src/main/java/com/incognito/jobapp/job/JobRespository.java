package com.incognito.jobapp.job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface JobRespository extends JpaRepository<Job, Long> {
}

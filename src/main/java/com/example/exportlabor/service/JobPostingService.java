package com.example.exportlabor.service;

import com.example.exportlabor.exception.JobPostingNotFound;
import com.example.exportlabor.model.JobPosting;
import com.example.exportlabor.repo.AgencyRepository;
import com.example.exportlabor.repo.JobPostingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobPostingService {
    private JobPostingRepository jobPostingRepository;
    private AgencyService agencyService;


    public JobPosting addJobPosting(JobPosting jobPosting){
        agencyService.findAgencyById(jobPosting.getAgency().getAgencyId());
        return jobPostingRepository.save(jobPosting);
    }

    public JobPosting findJobPostingById(Long id){
        return jobPostingRepository.findById(id).orElseThrow(() -> new JobPostingNotFound(id));
    }

    public List<JobPosting> findAllJobPostings(){
        return jobPostingRepository.findAll();
    }

    public JobPosting updateJobPosting(JobPosting jobPosting){
        findJobPostingById(jobPosting.getJobPostingId());
        agencyService.findAgencyById(jobPosting.getAgency().getAgencyId());
        return jobPostingRepository.save(jobPosting);
    }

}

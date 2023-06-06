package com.example.exportlabor.service;

import com.example.exportlabor.exception.EmployerNotFoundException;
import com.example.exportlabor.model.Agency;
import com.example.exportlabor.model.Employer;
import com.example.exportlabor.repo.EmployerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {
    private final EmployerRepository employerRepository;
    private final AgencyService agencyService;

    public EmployerService(EmployerRepository employerRepository, AgencyService agencyService) {
        this.employerRepository = employerRepository;
        this.agencyService = agencyService;
    }

    public Employer addEmployer(Employer employer) {
        Agency agency = agencyService.findAgencyById(employer.getAgency().getAgencyId());
        employer.setAgency(agency);
        return employerRepository.save(employer);
    }

    public List<Employer> getAllEmployers(){
        return employerRepository.findAll();
    }

    public Employer findEmployerById(Long id){
        return employerRepository.findById(id).orElseThrow(()-> new EmployerNotFoundException(id));
    }

    public Employer updateEmployer(Employer employer){
        findEmployerById(employer.getUserId());
        agencyService.findAgencyById(employer.getAgency().getAgencyId());
        return employerRepository.save(employer);
    }
}

package com.example.exportlabor.service;

import com.example.exportlabor.exception.AgencyNotFoundException;
import com.example.exportlabor.model.Agency;
import com.example.exportlabor.repo.AgencyRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyService {
    private AgencyRepository agencyRepository;

    @Autowired
    public AgencyService(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    public List<Agency> getAllAgency(){
        return agencyRepository.findAll();
    }

    public Agency findAgencyById(Long id){
        return agencyRepository.findById(id).orElseThrow(() -> new AgencyNotFoundException());
    }

    public Agency addAgency(Agency agency){
        return agencyRepository.save(agency);
    }

    public void updateAgency(Agency agency){
        if(agencyRepository.existsById(agency.getAgencyId())){
            agencyRepository.save(agency);
        }else throw new AgencyNotFoundException();
    }

}

package com.example.exportlabor.controller;

import com.example.exportlabor.model.Agency;
import com.example.exportlabor.model.User;
import com.example.exportlabor.model.Worker;
import com.example.exportlabor.service.AgencyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/agency")
public class AgencyController {
    private final AgencyService agencyService;

    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Agency>> getAllAgencies() {
        return new ResponseEntity<>(agencyService.getAllAgency(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Agency> getAgency(@PathVariable("id") Long id) {
        Agency agency = agencyService.findAgencyById(id);
        return new ResponseEntity<>(agency, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addAgency(@Valid @RequestBody Agency agency){
        agencyService.addAgency(agency);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Agency> updateAgency(@Valid @RequestBody Agency agency){
        agencyService.updateAgency(agency);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

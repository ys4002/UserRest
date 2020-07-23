package com.yash.service.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.model.Agency;
import com.yash.repo.AgencyRepository;

@Transactional
@Service(value = "agencyService")
public class AgencyService {
	
	@Autowired
	private AgencyRepository agencyRepo;
	
	@Autowired
	public AgencyService(AgencyRepository agencyRepo) {
		this.agencyRepo = agencyRepo;

	}
	
	public void delete(int id) {
		agencyRepo.deleteById(id);
	}

    public Agency save(Agency agency) {
        return agencyRepo.save(agency);
    }
    
    public Agency findByAgencyName(String name) {
    	return agencyRepo.findByAgencyName(name);
    }
}

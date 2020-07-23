package com.yash.service.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.model.Agency;
import com.yash.model.AgencyFeed;
import com.yash.model.Category;
import com.yash.repo.AgencyFeedRepository;

@Transactional
@Service(value = "agencyFeedService")
public class AgencyFeedService {
	
	@Autowired
	private AgencyFeedRepository agencyFeedRepo;
	
	@Autowired
	public AgencyFeedService(AgencyFeedRepository agencyFeedRepo) {
		this.agencyFeedRepo = agencyFeedRepo;

	}
	
	public void delete(int id) {
		agencyFeedRepo.deleteById(id);
	}

    public AgencyFeed save(AgencyFeed agencyFeed) {
        return agencyFeedRepo.save(agencyFeed);
    }
    
    public AgencyFeed findByAgencyRefAndCategoryRef(Agency agency, Category category) {
    	return agencyFeedRepo.findByAgencyRefAndCategoryRef(agency,category);
    }
    
    public List<AgencyFeed> findAll() {
    	return agencyFeedRepo.findAll();
    }

}

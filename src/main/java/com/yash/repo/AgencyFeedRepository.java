package com.yash.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.model.Agency;
import com.yash.model.AgencyFeed;
import com.yash.model.Category;

@Repository
public interface AgencyFeedRepository extends JpaRepository<AgencyFeed, Integer> {

	AgencyFeed findByAgencyRefAndCategoryRef(Agency agency, Category category);
	
	List<AgencyFeed> findAll();
}

package com.yash.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.model.Agency;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Integer> {

	Agency findByAgencyName(String name);
}

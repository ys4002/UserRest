package com.yash.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Category findByCategoryTitle(String title);
	
	List<Category> findAll();
}

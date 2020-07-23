package com.yash.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yash.model.Category;
import com.yash.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
	
	List<News> findAll();
	
	News findById(int id);
	
	@Modifying
	@Query(value = "truncate table News", nativeQuery = true)
	int deleteAllNews();

	@Query("select o from News o where o.categoryRef IN (?1) ORDER BY o.newsDate DESC")
	List<News> getNewsByCategory(List<Category> category);
}

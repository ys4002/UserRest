package com.yash.service.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.model.Category;
import com.yash.model.News;
import com.yash.repo.CategoryRepository;
import com.yash.repo.NewsRepository;

@Transactional
@Service(value = "newsService")
public class NewsService {
	
	@Autowired
	private NewsRepository newsRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	public NewsService(NewsRepository newsRepo, CategoryRepository categoryRepo ) {
		this.newsRepo = newsRepo;
		this.categoryRepo = categoryRepo;

	}
	
	public void delete(int id) {
		newsRepo.deleteById(id);
	}

    public News save(News news) {
        return newsRepo.save(news);
    }
    
    public List<News> findAll() {
    	return newsRepo.findAll();
    }
    
    public int deleteAllNews() {
    	return newsRepo.deleteAllNews();
    }
    
    public List<News> getNewsByCategory(List<String> category){
    	List<Category> temp = new ArrayList<>();
    	for(String cat : category) {
    		temp.add(categoryRepo.findByCategoryTitle(cat));
    	}
    	return newsRepo.getNewsByCategory(temp);
    }
    
    public News increaseCount(int id) {
    	News temp = newsRepo.findById(id);
    	temp.setClickCount(temp.getClickCount()+1);
    	return newsRepo.save(temp);
    }
}

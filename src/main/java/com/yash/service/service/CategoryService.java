package com.yash.service.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.model.Category;
import com.yash.repo.CategoryRepository;

@Transactional
@Service(value = "categoryService")
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	public CategoryService(CategoryRepository categoryRepo) {
		this.categoryRepo = categoryRepo;

	}
	
	public void delete(int id) {
		categoryRepo.deleteById(id);
	}

    public Category save(Category category) {
        return categoryRepo.save(category);
    }
    
    public Category findByCategoryTitle(String title) {
    	return categoryRepo.findByCategoryTitle(title);
    }
    
    public List<Category> findAll() {
    	return categoryRepo.findAll();
    }
}

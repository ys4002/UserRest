package com.yash.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.ApiResponse;
import com.yash.model.Category;
import com.yash.service.service.MasterService;
import com.yash.support.NewsSupport;

/**
 * This controller handles all the requests related to the news page 
 *
 * @author Yash
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/news")
public class NewsController extends MasterService {
	
	/**
	 * get Categories
	 * @return
	 */
	@GetMapping("/getcategory")
	public ApiResponse<Category> getCategory() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Category Data",categoryService.findAll());
	}
	
	/**
	 * get News based on categories selected
	 * @param data
	 * @return
	 */
	@GetMapping("/{data}")
	public ApiResponse<Category> getNews(@PathVariable List<String> data) {
		NewsSupport.categories = data;
		return new ApiResponse<>(HttpStatus.OK.value(), "News Data",newsService.getNewsByCategory(data));
	}
	
	/**
	 * Increase count of news
	 * @param id
	 * @return
	 */
	@GetMapping("/count/{id}")
	public ApiResponse<Category> increaseCount(@PathVariable int id) {
		return new ApiResponse<>(HttpStatus.OK.value(), "Count increased",newsService.increaseCount(id));
	}

	/**
	 * Fetch All News
	 * @return
	 */
	@GetMapping("/count")
	public ApiResponse<Category> fetchAll() {
		return new ApiResponse<>(HttpStatus.OK.value(), "All News Fetched",newsService.findAll());
	}

}

package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.FeedData;
import com.yash.service.service.MasterService;
import com.yash.support.NewsSupport;

/**
 * This controller handles all the function related to the logged in user
 * Add feed data (Agency, Category, Feed url)
 * Delete all News 
 * 
 * @author Yash
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/feed")
public class FeedController extends MasterService{
	
	@Autowired
	NewsSupport newsSupport;

	@PostMapping
    public void saveFeed(@RequestBody List<FeedData> data){
        newsSupport.updateFeed(data);
    }
	
	@GetMapping
    public void deleteNew(){
        newsService.deleteAllNews();
    }
}

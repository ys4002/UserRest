package com.yash.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/**
 * Controller with all services autowired to avoid creating new objects
 * 
 * @author Yash
 *
 */
@Configuration
@Controller
public class MasterService {
	@Autowired
	protected UserServiceImpl userService;

	@Autowired
	protected NewsService newsService;

	@Autowired
	protected CategoryService categoryService;

	@Autowired
	protected AgencyService agencyService;

	@Autowired
	protected AgencyFeedService agencyFeedService;

}

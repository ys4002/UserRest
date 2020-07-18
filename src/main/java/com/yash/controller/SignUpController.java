package com.yash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.ApiResponse;
import com.yash.model.User;
import com.yash.service.service.UserServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/signup")
public class SignUpController {
	
	@Autowired
    private UserServiceImpl userService;
	
	 @PostMapping
	    public ApiResponse<User> saveUser(@RequestBody User user){
	        return new ApiResponse<>(HttpStatus.OK.value(), "User Registered successfully.", userService.save(user));
	    }

}

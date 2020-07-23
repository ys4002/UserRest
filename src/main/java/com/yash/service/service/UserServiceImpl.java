package com.yash.service.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yash.model.User;
import com.yash.repo.UserRepository;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;

	}

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userRepo.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	
	public void delete(int id) {
		userRepo.deleteById(id);
	}

	
	public User findById(int id) {
		return userRepo.findById(id);
		
	}

    
    public User update(User user) {
        User updateUser = findById(user.getId());
        if(updateUser != null) {
            BeanUtils.copyProperties(user, updateUser, "password", "username");
            userRepo.save(updateUser);
        }
        return user;
    }

    public User save(User user) {
	    User newUser = new User();
	    newUser.setUsername(user.getUsername());
	    newUser.setFirstName(user.getFirstName());
	    newUser.setLastName(user.getLastName());
	    newUser.setPassword(bcryptEncoder.encode(user.getTempPass()));
        return userRepo.save(newUser);
    }
    
    public User findByUsername(String username) {
    	return userRepo.findByUsername(username);
    }
}

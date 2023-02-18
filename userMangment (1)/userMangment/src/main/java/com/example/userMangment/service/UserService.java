package com.example.userMangment.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userMangment.model.User;
import com.example.userMangment.repository.UserRepository;

import jakarta.validation.Valid;


@Service
public class UserService {

	 @Autowired
	  private UserRepository userRepository;

	  public User addUser(@Valid User user) {
	    user.setDate(new Timestamp(System.currentTimeMillis()));
	    user.setTime(new Timestamp(System.currentTimeMillis()));
	    return userRepository.save(user);
	  }

	  public User getUser(Integer userId) {
	    return userRepository.findById(userId).orElse(null);
	  }

	  public List<User> getAllUsers() {
	    return userRepository.findAll();
	  }

	  public User updateUser(Integer userId,@Valid User user) {
	    User currentUser = userRepository.findById(userId).orElse(null);
	    if(currentUser == null) {
	    	return null;
	    }
	    currentUser.setUserName(user.getUserName());
	    currentUser.setDateOfBirth(user.getDateOfBirth());
	    currentUser.setEmail(user.getEmail());
	    currentUser.setPhoneNo(user.getPhoneNo());
	    currentUser.setDate(new Timestamp(System.currentTimeMillis()));
	    currentUser.setTime(new Timestamp(System.currentTimeMillis()));
	    return userRepository.save(currentUser);
	  }
	  
	  public boolean deleteUser(Integer userId) {
		  User user = userRepository.findById(userId).orElse(null);
		  if(user==null) {
			  return false;
		  }
		  userRepository.delete(user);
		  return true;
	  }
	  
}

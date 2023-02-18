package com.example.userMangment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userMangment.model.User;
import com.example.userMangment.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<User>addUser(@RequestBody @Valid User user){
		User newUser = userService.addUser(user);
		return new ResponseEntity<>(newUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/userId/{userId}")
	public ResponseEntity<User> getUser(@PathVariable Integer userId){
		User user = userService.getUser(userId);
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<User>>getAllUser(){
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer userId){
		 boolean deleted = userService.deleteUser(userId);
		 if(!deleted) {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("userId/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Integer userId, @RequestBody @Valid User user){
        User updatedUser = userService.updateUser(userId, user);
        if(updatedUser == null) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<>(updatedUser,HttpStatus.OK);
	}
}

package com.nisum.users.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.users.dao.UserDAO;
import com.nisum.users.entity.User;
import com.nisum.users.logic.ServiceCrud;

@RestController
@RequestMapping("users")
public class UsersRest {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ServiceCrud service;

	// Get all users
	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		
		List<User> users = service.getAllUsers();
		return ResponseEntity.ok(users);
	}

	// Get User by ID
	@RequestMapping(value = "{userId}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(
			@PathVariable("userId") Long userId) {

		Optional<User> optionalUser = service.getUserById(userId);
		if (optionalUser.isPresent()) {
			return ResponseEntity.ok(optionalUser.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	// Create User
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		
		User newUser = service.createUser(user);
		if (newUser != null) {
			return ResponseEntity.ok(newUser);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	// Delete User
	@DeleteMapping
	public ResponseEntity<Long> deleteUser(
			@PathVariable("userId") Long userId) {
		
		if (service.deleteUser(userId).equals(userId)) {
			return ResponseEntity.ok(userId);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Edit User
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		
		Optional<User> optionalUser = userDAO.findById(user.getId());
		if (optionalUser.isPresent()) {
			User updatedUser = optionalUser.get();
			updatedUser.setName(user.getName());
			updatedUser.setPassword(user.getPassword());
			updatedUser.setEmail(user.getEmail());
			userDAO.save(updatedUser);
			return ResponseEntity.ok(updatedUser);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}

package com.nisum.users.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import com.nisum.users.dao.UserDAO;
import com.nisum.users.entity.User;

@Service
public class ServiceCrud {

	@Autowired
	private Util util;

	@Autowired
	private Adapter adapter;

	private UserDAO userDAO;
	Pair<User, List<String>> pairUserAndError = Pair.of(new User(),
			new ArrayList<String>());

	// Get all users
	public List<User> getAllUsers() {

		return userDAO.findAll();
	}

	// Get User by ID
	public Optional<User> getUserById(Long userId) {

		return userDAO.findById(userId);
	}

	// Create User
	public User createUser(User userToBeCreated) {

		User user = new User();

		if (userToBeCreated == null) {
			String message = "User to be created is null";
			return user;
		}

		if (!util.isValidPassword(userToBeCreated.getPassword())) {
			String message = "Password pattern is not valid";
			return user;
		}
		if (!util.isValidEmail(userToBeCreated.getEmail())) {
			String message = "Email pattern is not valid";
			return user;
		}

		return userDAO.save(userToBeCreated);
	}

	// Delete User
	public Long deleteUser(Long userId) {

		if (!userDAO.existsById(userId)) {
			return -1L;
		}

		userDAO.deleteById(userId);
		return userId;
	}

	// Edit User
	public User updateUser(User userToBeUpdated) {
		Optional<User> optionalUser = userDAO.findById(userToBeUpdated.getId());
		User user = new User();
		List<String> errores = new ArrayList<String>();
		if (optionalUser.isPresent()) {
			User updatedUser = optionalUser.get();
			errores = adapter.validateData(updatedUser);
			if (errores.isEmpty()) {
				updatedUser.setName(userToBeUpdated.getName());
				updatedUser.setPassword(userToBeUpdated.getPassword());
				updatedUser.setEmail(userToBeUpdated.getEmail());
				return userDAO.save(updatedUser);
			}
		}
		return user;
	}
}

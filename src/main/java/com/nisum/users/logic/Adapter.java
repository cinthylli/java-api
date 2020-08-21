package com.nisum.users.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.nisum.users.dao.UserDAO;
import com.nisum.users.entity.User;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Adapter {

	@Autowired
	private UserDAO userDao;

	@Autowired
	private Util util;

	public List<String> validateData(User user) {
		List<String> errores = new ArrayList<>();

		if (!util.isValidPassword(user.getPassword())) {
			String message = "Password pattern is not valid";
			errores.add(message);
		}
		if (!util.isValidEmail(user.getEmail())) {
			String message = "Email pattern is not valid";
			errores.add(message);
		}

		if (user.getName().isEmpty()) {
			errores.add("Name is empty");
		}

		if (user.getPassword().isEmpty()) {
			errores.add("Password is empty");
		}

		if (user.getEmail().isEmpty()) {
			errores.add("Email is empty");
		}

		return errores;
	}

}

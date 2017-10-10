package org.fbf.service;

import java.util.ArrayList;
import java.util.List;

import org.fbf.dao.repositories.UserRepository;
import org.fbf.model.Permission;
import org.fbf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 
 * @author amushate 09 Oct,2017
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private LoggedInChecker loggedInChecker;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PermissionService permissionService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findOne(username);
	}

	@Override
	public List<String> getPermissions(String username) {
		return new ArrayList<>();
	}

	@Override
	public User getCurrentUser() {
		return loggedInChecker.getLoggedInUser();
	}

	@Override
	public Boolean isCurrentUserLoggedIn() {
		return loggedInChecker.getLoggedInUser() != null;
	}

	@Override
	public User createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User addPermission(String username, String role) {
		User user = getUserByUsername(username);
		Permission permission = permissionService.findPermission(role);
		user.getPermissions().add(permission);
		return userRepository.save(user);
	}

	@Override
	public User login(User user) {
		return getUserByUsername(user.getUsername());
	}
}
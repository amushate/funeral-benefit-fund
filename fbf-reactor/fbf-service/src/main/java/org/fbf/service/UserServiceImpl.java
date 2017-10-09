package org.fbf.service;

import java.util.ArrayList;
import java.util.List;

import org.fbf.dao.repositories.UserRepository;
import org.fbf.model.Permission;
import org.fbf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author amushate 09 Oct,2017
 */
@Service
public class UserServiceImpl implements UserService {

	private final LoggedInChecker loggedInChecker;

	private UserRepository userRepository;

	private PermissionService permissionService;

	@Autowired
	UserServiceImpl(LoggedInChecker loggedInChecker, UserRepository userRepository,
			PermissionService permissionService) {
		this.loggedInChecker = loggedInChecker;
		this.userRepository = userRepository;
		this.permissionService = permissionService;
	}

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
		return userRepository.save(user);
	}

	@Override
	public User addPermission(String username, String role) {
		User user = getUserByUsername(username);
		Permission permission = permissionService.findPermission(role);
		user.getPermissions().add(permission);
		return userRepository.save(user);
	}
}
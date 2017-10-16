package org.fbf.service;

import java.util.List;

import org.fbf.model.User;

/**
 * 
 * @author amushate 09 Oct,2017
 */
public interface UserService {
	User getUserByUsername(String username);

	List<String> getPermissions(String username);

	User getCurrentUser();

	Boolean isCurrentUserLoggedIn();

	User createUser(User user);

	User addPermission(String username, String role);

	User login(String username,String password);

	User getUserByUsernameAndPassword(String username, String password);
}
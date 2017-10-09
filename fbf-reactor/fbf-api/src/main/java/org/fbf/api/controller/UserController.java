package org.fbf.api.controller;

import static org.springframework.http.ResponseEntity.ok;

import org.fbf.model.Permission;
import org.fbf.model.User;
import org.fbf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author amushate 09 Oct,2017
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
	private final UserService userService;

	@Autowired
	UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(path="/loggedin")
	ResponseEntity<Boolean> isCurrentUserLoggedIn() {
		return new ResponseEntity<>(userService.isCurrentUserLoggedIn(), HttpStatus.OK);
	}

	@GetMapping(path="/current")
	ResponseEntity<User> getCurrentUser() {
		return ok(userService.getCurrentUser());
	}
	
	@PostMapping
	ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
	}
	
	@PostMapping("/{username}/roles")
	ResponseEntity<User> updateUser(@PathVariable String username,@RequestBody Permission permission) {
		return new ResponseEntity<>(userService.addPermission(username,permission.getRole()), HttpStatus.OK);
	}
}
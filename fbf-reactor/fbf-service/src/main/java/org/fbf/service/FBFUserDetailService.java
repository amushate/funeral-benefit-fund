package org.fbf.service;

import java.util.ArrayList;
import java.util.List;

import org.fbf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 
 * @author amushate 09 Oct,2017
 */
@Service
public class FBFUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserService userService;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		List<String> permissions = userService.getPermissions(user.getUsername());
		for (String permission : permissions) {
			grantedAuthorities.add(new SimpleGrantedAuthority(permission));
		}

		return new FBFUserDetails(user, grantedAuthorities);
	}

}

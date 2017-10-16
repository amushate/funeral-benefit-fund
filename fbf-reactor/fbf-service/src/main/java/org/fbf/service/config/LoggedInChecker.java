package org.fbf.service.config;

import org.fbf.model.User;
import org.fbf.service.FBFUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * 
 * @author amushate 09 Oct,2017
 */
@Component
public class LoggedInChecker {
	public User getLoggedInUser() {
		User user = null;

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			Object principal = authentication.getPrincipal();

			// principal can be "anonymousUser" (String)
			if (principal instanceof FBFUserDetails) {
				FBFUserDetails userDetails = (FBFUserDetails) principal;
				user = userDetails.getUser();
			}
		}

		return user;
	}
}
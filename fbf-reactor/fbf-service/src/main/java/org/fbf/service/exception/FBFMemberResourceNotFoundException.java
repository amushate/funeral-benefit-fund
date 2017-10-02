/**
 * 
 */
package org.fbf.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author amushate 02 Oct,2017
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FBFMemberResourceNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public FBFMemberResourceNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public FBFMemberResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public FBFMemberResourceNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

/**
 * 
 */
package org.fbf.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author amushate 29 Sep,2017
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class FBFMemberDuplicateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public FBFMemberDuplicateException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public FBFMemberDuplicateException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public FBFMemberDuplicateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

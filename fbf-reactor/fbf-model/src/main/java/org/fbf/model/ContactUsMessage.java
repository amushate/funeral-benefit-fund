/**
 * 
 */
package org.fbf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author amushate 23 Oct,2017
 */
@Entity
public class ContactUsMessage {

	private Long contactUsMessageId;
	private String fullName;
	private String email;
	private String message;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getContactUsMessageId() {
		return contactUsMessageId;
	}

	public void setContactUsMessageId(Long contactUsMessageId) {
		this.contactUsMessageId = contactUsMessageId;
	}

}

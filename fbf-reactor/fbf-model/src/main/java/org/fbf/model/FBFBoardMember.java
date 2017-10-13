/**
 * 
 */
package org.fbf.model;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * @author amushate 13 Oct,2017
 */
@Entity
public class FBFBoardMember implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long fbfBoardMemberId;
	private String title;
	private String fullName;
	private String phoneNumber;
	private String email;
	private String qualities;
	private String imageUrl;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQualities() {
		return qualities;
	}

	public void setQualities(String qualities) {
		this.qualities = qualities;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Long getFbfBoardMemberId() {
		return fbfBoardMemberId;
	}

	public void setFbfBoardMemberId(Long fbfBoardMemberId) {
		this.fbfBoardMemberId = fbfBoardMemberId;
	}

}

/**
 * 
 */
package org.fbf.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author amushate 13 Oct,2017
 */
@Entity
@Access(AccessType.PROPERTY)
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getFbfBoardMemberId() {
		return fbfBoardMemberId;
	}

	public void setFbfBoardMemberId(Long fbfBoardMemberId) {
		this.fbfBoardMemberId = fbfBoardMemberId;
	}

	@Override
	public String toString() {
		return "FBFBoardMember [fbfBoardMemberId=" + fbfBoardMemberId + ", title=" + title + ", fullName=" + fullName
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", qualities=" + qualities + ", imageUrl="
				+ imageUrl + "]";
	}
	
	

}

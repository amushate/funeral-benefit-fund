/**
 * 
 */
package org.fbf.api.ui.model;

import java.util.Date;

import org.fbf.enums.Gender;
import org.fbf.enums.MemberStatus;

/**
 * @author amushate 03 Oct,2017
 */
public class UIFBFMember {

	private String firstName;
	private String surname;
	private Gender gender;
	private String nationalId;
	private String employeeId;

	private Date dob;
	private Long fbfMemberId;
	private MemberStatus memberStatus;
	private String phoneNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public MemberStatus getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(MemberStatus memberStatus) {
		this.memberStatus = memberStatus;
	}

	public Long getFbfMemberId() {
		return fbfMemberId;
	}

	public void setFbfMemberId(Long fbfMemberId) {
		this.fbfMemberId = fbfMemberId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}

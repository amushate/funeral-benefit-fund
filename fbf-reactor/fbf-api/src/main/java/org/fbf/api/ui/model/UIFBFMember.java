/**
 * 
 */
package org.fbf.api.ui.model;

import java.time.LocalDate;

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
	private LocalDate dob;
	private MemberStatus memberStatus;

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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public MemberStatus getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(MemberStatus memberStatus) {
		this.memberStatus = memberStatus;
	}

}

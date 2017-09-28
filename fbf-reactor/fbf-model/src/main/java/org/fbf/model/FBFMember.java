/**
 * 
 */
package org.fbf.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.fbf.enums.Gender;
import org.fbf.enums.MemberStatus;

/**
 * @author amushate 25 Sep,2017
 */
@Entity
@Access(AccessType.PROPERTY)
public class FBFMember implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fbfMemberIdentifier = UUID.randomUUID().toString();
	private Long fbfMemberId;
	private String firstName;
	private String Surname;
	private Gender gender;
	private String nationalId;
	private String employeeId;
	private LocalDate dob;
	private MemberStatus memberStatus;
	private AuditInfo auditInfo;

	private List<Dependant>dependants;
	
	public String getFbfMemberIdentifier() {
		return fbfMemberIdentifier;
	}

	public void setFbfMemberIdentifier(String fbfMemberIdentifier) {
		this.fbfMemberIdentifier = fbfMemberIdentifier;
	}

	public Long getFbfMemberId() {
		return fbfMemberId;
	}

	public void setFbfMemberId(Long fbfMemberId) {
		this.fbfMemberId = fbfMemberId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
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

	@Enumerated(EnumType.STRING)
	public MemberStatus getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(MemberStatus memberStatus) {
		this.memberStatus = memberStatus;
	}

	@Embedded
	public AuditInfo getAuditInfo() {
		return auditInfo;
	}

	public void setAuditInfo(AuditInfo auditInfo) {
		this.auditInfo = auditInfo;
	}

	public List<Dependant> getDependants() {
		return dependants;
	}

	public void setDependants(List<Dependant> dependants) {
		this.dependants = dependants;
	}

}

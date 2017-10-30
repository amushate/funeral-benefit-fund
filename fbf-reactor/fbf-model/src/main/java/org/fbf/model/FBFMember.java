/**
 * 
 */
package org.fbf.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.fbf.enums.Gender;
import org.fbf.enums.MemberStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private String surname;
	private Gender gender;
	private String nationalId;
	private String employeeId;
	private Date dob;
	private MemberStatus memberStatus;
	private AuditInfo auditInfo;
	private String phoneNumber;

	private List<Dependant> dependants;

	public String getFbfMemberIdentifier() {
		return fbfMemberIdentifier;
	}

	public void setFbfMemberIdentifier(String fbfMemberIdentifier) {
		this.fbfMemberIdentifier = fbfMemberIdentifier;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Enumerated(EnumType.STRING)
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

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fbfMember")
	@JsonIgnore
	public List<Dependant> getDependants() {
		return dependants;
	}

	public void setDependants(List<Dependant> dependants) {
		this.dependants = dependants;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}

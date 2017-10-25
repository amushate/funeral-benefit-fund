package org.fbf.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.fbf.enums.Gender;

/**
 * 
 * @author amushate 29 Sep,2017
 */
@Entity
public class Dependant implements Serializable{

	private static final long serialVersionUID = 1L;
	private String fbfMemberIdentifier = UUID.randomUUID().toString();
	private Long dependantId;
	private String name;
	private String surname;
	private Date dob;
	private String relationShipType;
	private FBFMember fbfMember;
	private String nationalId;
	private Gender gender;

	public String getFbfMemberIdentifier() {
		return fbfMemberIdentifier;
	}

	public void setFbfMemberIdentifier(String fbfMemberIdentifier) {
		this.fbfMemberIdentifier = fbfMemberIdentifier;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getDependantId() {
		return dependantId;
	}

	public void setDependantId(Long dependantId) {
		this.dependantId = dependantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@ManyToOne(optional=false,fetch=FetchType.LAZY)
	@JoinColumn(name="fbfMemberId", nullable=false, updatable=false)
	public FBFMember getFbfMember() {
		return fbfMember;
	}

	public void setFbfMember(FBFMember fbfMember) {
		this.fbfMember = fbfMember;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public String getRelationShipType() {
		return relationShipType;
	}

	public void setRelationShipType(String relationShipType) {
		this.relationShipType = relationShipType;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}

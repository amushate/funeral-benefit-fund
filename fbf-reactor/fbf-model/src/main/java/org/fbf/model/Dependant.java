package org.fbf.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author amushate 29 Sep,2017
 */
@Entity
public class Dependant {

	private String fbfMemberIdentifier = UUID.randomUUID().toString();
	private Long dependantId;
	private String name;
	private String surname;
	private LocalDate dob;
	private RelationShip relationShip;
	private FBFMember fbfMember;

	public String getFbfMemberIdentifier() {
		return fbfMemberIdentifier;
	}

	public void setFbfMemberIdentifier(String fbfMemberIdentifier) {
		this.fbfMemberIdentifier = fbfMemberIdentifier;
	}

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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public RelationShip getRelationShip() {
		return relationShip;
	}

	public void setRelationShip(RelationShip relationShip) {
		this.relationShip = relationShip;
	}

	@ManyToOne(optional=false)
    @JoinColumn(name="fbfMemberId", nullable=false, updatable=false)
	public FBFMember getFbfMember() {
		return fbfMember;
	}

	public void setFbfMember(FBFMember fbfMember) {
		this.fbfMember = fbfMember;
	}

}

/**
 * 
 */
package org.fbf.api.ui.model;

import java.time.LocalDate;

import org.fbf.enums.RelationShipType;

/**
 * @author amushate 06 Oct,2017
 */
public class UIDependant {

	private String fbfMemberIdentifier;
	private Long dependantId;
	private String name;
	private String surname;
	private LocalDate dob;
	private RelationShipType relationShipType;
	private String nationalId;

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

	public RelationShipType getRelationShipType() {
		return relationShipType;
	}

	public void setRelationShipType(RelationShipType relationShipType) {
		this.relationShipType = relationShipType;
	}

	public String getNationalId() {
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

}

package org.fbf.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Permission {

	@Id
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}

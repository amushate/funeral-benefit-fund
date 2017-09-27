package org.fbf.enums;

public enum MemberStatus {

	ACTIVE("active"), SUSPENDED("suspended"),PA("pending_activation"),WP("waiting_period");

	private String value;

	private MemberStatus(final String value) {
		this.value = value;
	}

	public static Gender fromValue(final String value) {
		for (Gender gender : Gender.values()) {
			if (gender.getValue().equalsIgnoreCase(value)) {
				return gender;
			}
		}
		return null;
	}

	public String getValue() {
		return value;
	}
}

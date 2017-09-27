/**
 * 
 */
package org.fbf.enums;

/**
 * @author amushate 25 Sep,2017
 */
public enum Gender {
	MALE("Male"), FEMALE("Female");

	private String value;

	private Gender(final String value) {
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

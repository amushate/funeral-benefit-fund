package org.fbf.enums;

public enum RelationShipType {

	SON("Son"), DAUGTHER("Daugther"),SPOUSE("Spouse");

	private String value;

	private RelationShipType(final String value) {
		this.value = value;
	}

	public static RelationShipType fromValue(final String value) {
		for (RelationShipType relationShipType : RelationShipType.values()) {
			if (relationShipType.getValue().equalsIgnoreCase(value)) {
				return relationShipType;
			}
		}
		return null;
	}

	public String getValue() {
		return value;
	}
}

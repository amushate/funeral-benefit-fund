package org.fbf.enums;

/**
 * 
 * @author amushate 19 Oct,2017
 */
public enum DocumentType {

	PAYMENT("Payment"), FBF_MEMBER("fbf_member"),FBF_BOARD_MEMBER("fbf_board_member")
	,DEPENDANT("dependant"),USER("user");

	private String value;

	private DocumentType(final String value) {
		this.value = value;
	}

	public static DocumentType fromValue(final String value) {
		for (DocumentType documentType : DocumentType.values()) {
			if (documentType.getValue().equalsIgnoreCase(value)) {
				return documentType;
			}
		}
		return null;
	}

	public String getValue() {
		return value;
	}
}

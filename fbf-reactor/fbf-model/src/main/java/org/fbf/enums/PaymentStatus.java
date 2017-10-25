/**
 * 
 */
package org.fbf.enums;

/**
 * @author amushate 25 Oct,2017
 */
public enum PaymentStatus {
	PENDING_VERIFICATION("Pending Verification"), APPROVED("Approved"),REJECTED("Rejected");

	private String value;

	private PaymentStatus(final String value) {
		this.value = value;
	}

	public static PaymentStatus fromValue(final String value) {
		for (PaymentStatus paymentStatus : PaymentStatus.values()) {
			if (paymentStatus.getValue().equalsIgnoreCase(value)) {
				return paymentStatus;
			}
		}
		return null;
	}

	public String getValue() {
		return value;
	}
}

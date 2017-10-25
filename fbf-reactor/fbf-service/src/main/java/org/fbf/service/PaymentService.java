/**
 * 
 */
package org.fbf.service;

import java.util.List;

import org.fbf.model.Payment;

/**
 * @author amushate 25 Oct,2017
 */
public interface PaymentService {
	
	Payment findPayment(Long paymentId);

	Payment addPayment(Payment payment);

	Payment updatePayment(Long paymentId, Payment payment);

	Payment rejectPayment(Long paymentId, String reason,String rejectedBy);

	Payment approvePayment(Long paymentId,String approvedBy);
	
	List<Payment>listPayments();
	
	List<Payment> findPaymentByFbfMember(Long fbfMember);
}

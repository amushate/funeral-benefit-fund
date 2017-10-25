/**
 * 
 */
package org.fbf.service;

import java.util.Date;
import java.util.List;

import org.fbf.dao.repositories.PaymentRepository;
import org.fbf.enums.PaymentStatus;
import org.fbf.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author amushate 25 Oct,2017
 */
@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment addPayment(Payment payment) {
		payment.setStatus(PaymentStatus.PENDING_VERIFICATION);
		payment.setCapturedDate(new Date());
		return paymentRepository.save(payment);
	}

	@Override
	public Payment updatePayment(Long paymentId, Payment payment) {
		Payment oldPayment = findPayment(paymentId);
		oldPayment.setAmount(payment.getAmount());
		oldPayment.setReference(payment.getReference());
		oldPayment.setPaymentDate(payment.getPaymentDate());
		return paymentRepository.save(oldPayment);
	}

	@Override
	public Payment rejectPayment(Long paymentId, String reason, String rejectedBy) {
		Payment payment = findPayment(paymentId);
		payment.setStatus(PaymentStatus.REJECTED);
		payment.setRejectedBy(rejectedBy);
		payment.setRejectionReason(reason);
		payment.setRejectedDate(new Date());
		return paymentRepository.save(payment);
	}

	@Override
	public Payment approvePayment(Long paymentId,String approvedBy) {
		Payment payment = findPayment(paymentId);
		payment.setStatus(PaymentStatus.APPROVED);
		payment.setApprovedBy(approvedBy);
		payment.setApprovedDate(new Date());
		return paymentRepository.save(payment);
	}

	@Override
	public Payment findPayment(Long paymentId) {
		return paymentRepository.findOne(paymentId);
	}

	@Override
	public List<Payment> listPayments() {
		return paymentRepository.findAll();
	}

	@Override
	public List<Payment> findPaymentByFbfMember(Long fbfMemberId) {
		return paymentRepository.findByFbfmemberId(fbfMemberId);
	}

}

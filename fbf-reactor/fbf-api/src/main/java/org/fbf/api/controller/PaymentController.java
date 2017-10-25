/**
 * 
 */
package org.fbf.api.controller;

import java.util.List;

import org.fbf.model.Payment;
import org.fbf.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author amushate 25 Oct,2017
 */
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping
	public Payment createPayment(@RequestBody Payment payment){
		return paymentService.addPayment(payment);
	}
	
	@GetMapping(path="/{paymentId}")
	public Payment findPayment(@PathVariable Long paymentId){
		return paymentService.findPayment(paymentId);
	}
	
	@GetMapping
	public List<Payment> listPayments(){
		return paymentService.listPayments();
	}
	
	@GetMapping(path="/member/{fbfmemberId}")
	public List<Payment> listPaymentByMemberId(@PathVariable Long fbfmemberId){
		return paymentService.findPaymentByFbfMember(fbfmemberId);
	}
	
	@PutMapping(path="/{paymentId}")
	public Payment updatePayment(@PathVariable Long paymentId,@RequestBody Payment payment){
		return paymentService.updatePayment(paymentId, payment);
	}
	
	@PutMapping(path="/{paymentId}/reject")
	public Payment rejectPayment(@PathVariable Long paymentId,@RequestBody Payment payment){
		return paymentService.rejectPayment(paymentId, payment.getRejectionReason(), payment.getRejectedBy());
	}
	
	@PutMapping(path="/{paymentId}/approve")
	public Payment approvePayment(@PathVariable Long paymentId, @RequestBody Payment payment){
		return paymentService.approvePayment(paymentId, payment.getApprovedBy());
	}
	
}

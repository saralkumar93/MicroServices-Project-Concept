package com.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentservice.entity.Payment;
import com.paymentservice.services.PaymentService;

@RestController
@RequestMapping("payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/doPayment")
	public Payment doPayment(@RequestBody Payment payment) {
		
		return paymentService.doPayment(payment);
	}
	
	@RequestMapping("/orderId")
	public Payment findPaymentHistoryByOrderId(@PathVariable int orderId) {
		return paymentService.findPaymentHistoryByOrderId(orderId);
	}
	

}

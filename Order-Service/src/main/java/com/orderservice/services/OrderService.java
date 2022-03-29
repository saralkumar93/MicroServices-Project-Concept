package com.orderservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orderservice.common.Payment;
import com.orderservice.common.TransactionRequest;
import com.orderservice.common.TransactionResponse;
import com.orderservice.entity.Order;
import com.orderservice.repository.OrderRepository;

@Service
@RefreshScope
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	//@Lazy
	private RestTemplate restTemplate;
	
	//@Value("${microservice.payment.service.endpoints.endpoint.uri}")
	//private String ENDPOINT_URL;
	
	
	public TransactionResponse saveOrder(TransactionRequest request)
	{
		String response="";
		Order order=request.getOrder();
		Payment payment=request.getPayment();
		payment.setOrderId(order.getId());;
		payment.setAmount(order.getPrice());
		
		
		//rest call
		Payment paymentResponse=restTemplate.postForObject("http://localhost:9001/payment/doPayment", payment, Payment.class);
		
		response= paymentResponse.getPaymentStatus().equals("success")?"payment processing successful and order place placed":"there is a failure in paymeent api,order added to cart";
		
		
		
		
		orderRepository.save(order);
		
		return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
	}

	
}

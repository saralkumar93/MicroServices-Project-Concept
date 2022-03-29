package com.apigateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {
	
	@RequestMapping("/orderFallBack")
	public Mono<String> orderServiceFallBack(){
		return Mono.just("Order Service is taking too long to respond or is down. please try again later");
	}
	@RequestMapping("/paymentFallBack")
	public Mono<String> paymentServicecFallBack(){
		return Mono.just("payment service is taking too long to respnd or is down.please try again later");
	}
	

}

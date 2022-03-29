package com.orderservice.common;

import com.orderservice.entity.Order;

public class TransactionResponse {
	private Order order;
	private double amount;
	private String transactionId;
	private String message;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public TransactionResponse(Order order, double d, String transactionId, String message) {
		super();
		this.order = order;
		this.amount = d;
		this.transactionId = transactionId;
		this.message = message;
	}
	public TransactionResponse() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}

package com.ojas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ojas.common.Payment;
import com.ojas.common.TransactionRequest;
import com.ojas.common.TransactionResponse;
import com.ojas.dao.OrderDao;
import com.ojas.entity.Order;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderdao;
	
	@Autowired
	private RestTemplate template;
	
	public TransactionResponse saveOrder(TransactionRequest request) {
		String response="";
		Order order = request.getOrder();
		Payment payment=request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		
		//rest call
		Payment paymentResponse= template.postForObject("http://Payment-Service/payment/doPayment", payment, Payment.class);
		
		response = paymentResponse.getPaymentStatus().equals("sucess") ? "payment processing sucessful and order placed" : "there is a failure in payment api , order added to card";
		
		orderdao.save(order);
		return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
	}
}

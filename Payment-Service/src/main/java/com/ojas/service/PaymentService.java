package com.ojas.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.dao.PaymentDao;
import com.ojas.entity.Payment;

@Service
public class PaymentService {

	@Autowired
	private PaymentDao paymentDao;
	
	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentDao.save(payment);
	}
	
	public String paymentProcessing() {
		//api should be third party payment getway (paypal,paytm..)
		return new Random().nextBoolean()?"sucess":"false";
	}

	public Payment findByOrderId(int orderId) {
		
		return paymentDao.findByOrderId(orderId);
	}
	
}

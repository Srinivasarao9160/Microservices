package com.ojas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.entity.Payment;

@Repository
public interface PaymentDao extends JpaRepository<Payment, Integer> {

	Payment findByOrderId(int orderId);

}

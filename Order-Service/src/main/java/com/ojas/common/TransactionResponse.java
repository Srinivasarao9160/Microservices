package com.ojas.common;

import com.ojas.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
	
	private Order order;
	private double amount;
	private String TransactionId;
	private String message;

}

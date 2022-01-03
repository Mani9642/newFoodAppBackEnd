package com.cigniti.foodApp.service;

import java.util.List;

import com.cigniti.foodApp.entity.Payment;

public interface PaymentService {

	public List<Payment> getAllPayments();

	public Payment savePayment(Payment payment);

	public Payment findByPaymentId(int id);

	public void deleteByPaymentId(int id);

}

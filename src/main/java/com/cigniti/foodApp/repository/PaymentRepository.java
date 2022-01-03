package com.cigniti.foodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cigniti.foodApp.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}

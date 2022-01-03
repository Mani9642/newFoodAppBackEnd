package com.cigniti.foodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cigniti.foodApp.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Integer> {

}

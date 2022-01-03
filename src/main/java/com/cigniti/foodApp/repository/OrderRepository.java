package com.cigniti.foodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cigniti.foodApp.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}

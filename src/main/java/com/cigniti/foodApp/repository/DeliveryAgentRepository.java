package com.cigniti.foodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cigniti.foodApp.entity.DeliveryAgent;

public interface DeliveryAgentRepository extends JpaRepository<DeliveryAgent,Integer> {

}

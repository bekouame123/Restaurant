package com.restaurant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.entity.OrderEntity;

import jakarta.persistence.criteria.Order;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long>{



}

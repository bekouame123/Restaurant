package com.restaurant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.entity.CustomerEntity;
import com.restaurant.service.CustomerService;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {

	Optional<CustomerRepository> findByUsername(String username);

	static void saveAll(CustomerService customerService) {
		// TODO Auto-generated method stub
		
	}

	static void save(CustomerService customerService) {
		// TODO Auto-generated method stub
		
	}
}
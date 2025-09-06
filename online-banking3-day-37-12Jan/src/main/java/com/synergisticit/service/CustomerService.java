package com.synergisticit.service;

import java.util.List;

import com.synergisticit.domain.Customer;



public interface CustomerService {
	Customer save(Customer customer);
	Customer findById(Long customerId);
	List<Customer> findAll();
	Customer updateById(Long customerId);
	void deleteById(Long customerId);
			

}

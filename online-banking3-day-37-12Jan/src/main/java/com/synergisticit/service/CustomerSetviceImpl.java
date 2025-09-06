package com.synergisticit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisticit.domain.Customer;
import com.synergisticit.repository.CustomerRepository;

@Service
public class CustomerSetviceImpl implements CustomerService {
	@Autowired CustomerRepository customerRepository;

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer findById(Long customerId) {
		
		return customerRepository.getById(customerId);
	}

	@Override
	public List<Customer> findAll() {
		
		return customerRepository.findAll();
	}

	@Override
	public Customer updateById(Long customerId) {
		
		return customerRepository.findById(customerId).get();
	}

	@Override
	public void deleteById(Long customerId) {
		customerRepository.deleteById(customerId);
		
	}

}

package com.invento.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;

import com.invento.customer.dto.CustomerDto;
import com.invento.customer.model.Customer;

public interface CustomerService {

	public List<Customer> getCustomerList(int pageNumber, int pageSize,
			String field, Sort.Direction sortDirection);

	public Optional<Customer> getCustomerById(Long id);

	public boolean addCustomer(CustomerDto dto);

	public boolean deleteCustomerById(long id);
	
	public Optional<Customer> getCustomerByEmail(String email);

	public Optional<Customer> getDetailsPostLogin(Authentication authentication);
}

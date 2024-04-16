package com.invento.customer.mapper;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.invento.customer.dto.CustomerDto;
import com.invento.customer.model.Customer;

@Component
public class CustomerMapper {

	public Customer dtoToCustomer(CustomerDto dto) {

		Customer customer = new Customer();
		if (Objects.nonNull(dto)) {
			customer.setFirstName(dto.getFirstName());
			customer.setLastName(dto.getLastName());
			customer.setEmail(dto.getEmail());
			customer.setPassword(dto.getPassword());
			customer.setContact(dto.getContact());
			customer.setAuthorities(dto.getAuthorities());
		}
		return customer;
	}
}

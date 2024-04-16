package com.invento.customer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.invento.customer.dto.CustomerDto;
import com.invento.customer.mapper.CustomerMapper;
import com.invento.customer.model.Address;
import com.invento.customer.model.Customer;
import com.invento.customer.repository.CustomerRepo;
import com.invento.customer.service.AddressService;
import com.invento.customer.service.CustomerService;

import jakarta.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepo customerRepo;

	private CustomerMapper customerMapper;

	private AddressService addressService;

	private PasswordEncoder passwordEncoder;

	private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

	public CustomerServiceImpl(CustomerRepo customerRep, CustomerMapper customerMapper, AddressService addressService,
			PasswordEncoder passwordEncoder) {
		this.customerRepo = customerRep;
		this.customerMapper = customerMapper;
		this.addressService = addressService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public List<Customer> getCustomerList(int pageNumber, int pageSize,
			String field, Sort.Direction sortDirection) {
		List<Customer> customers = new ArrayList<>();
		try {
			Pageable pageRequest = PageRequest.of(pageNumber, pageSize, sortDirection, field);
			customers = customerRepo.findAllByDeleted(false, pageRequest);
		} catch (Exception e) {
			log.error("Could not found customers.");
		}
		return customers;
	}

	@Override
	public Optional<Customer> getCustomerById(Long id) {
		Optional<Customer> customerOp = Optional.empty();
		try {
			customerOp = customerRepo.findByIdAndDeleted(id, false);
			if (customerOp.isEmpty()) {
				log.error("Customer not found with id: {}", id);
			}
		} catch (Exception e) {
			log.error("Error finidng customer with id: {}", id);
		}
		return customerOp;
	}

	@Override
	@Transactional
	public boolean addCustomer(CustomerDto dto) {
		boolean created = false;
		try {
			encodePassword(dto);
			Customer customer = customerMapper.dtoToCustomer(dto);
			handleAddress(dto, customer);
			customer = customerRepo.save(customer);
			created = true;
			log.info("Customer created. Customer details : {}", customer);
		} catch (Exception e) {
			log.error("Customer creation failed. Error: ", e);
		}
		return created;
	}

	@Override
	@Transactional
	public boolean deleteCustomerById(long id) {
		Boolean deleted = false;
		try {
			Optional<Customer> customerOp = customerRepo.findById(id);
			if (customerOp.isPresent()) {
				Customer customer = customerOp.get();
				customer.setDeleted(true);
				customerRepo.save(customer);
				deleted = true;
			} else {
				log.error("Customer not found with id: {}", id);
			}
		} catch (Exception e) {
			log.error("Error deleting customer with id: {}. Error: {}", id, e.getMessage());
		}
		return deleted;
	}

	private void handleAddress(CustomerDto dto, Customer customer) {

		if (Objects.nonNull(dto.getBillingAddress())) {
			Address billingAddress = addressService.addAddress(dto.getBillingAddress());
			customer.setBillingAddress(billingAddress);
			if (dto.isShippingSABilling()) {
				customer.setShippingAddress(billingAddress);
			} else {
				Address shippinngAddress = addressService.addAddress(dto.getShippingAddress());
				customer.setShippingAddress(shippinngAddress);
			}
		}
	}

	@Override
	public List<Customer> getCustomerByEmail(String email) {
		List<Customer> customers = new ArrayList<>();
		if (email != null) {
				customers = customerRepo.findByEmail(email);
		} else {
			log.error("Unable to find user by email: {}", email);
		}
		return customers;
	}

	private void encodePassword(CustomerDto dto) {
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
	}

	@Override
	public Optional<Customer> getDetailsPostLogin(Authentication authentication) {
		List<Customer> customers = customerRepo.findByEmail(authentication.getName());
		if(customers.size()>0) {
			return Optional.of(customers.get(0));
		}
		return Optional.empty();
	}
}

package com.invento.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.invento.customer.dto.CustomerDto;
import com.invento.customer.model.Customer;
import com.invento.customer.service.CustomerService;
import com.invento.customer.util.Constants;

@RestController
@RequestMapping(Constants.CUSTOMER)
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping(Constants.LOGIN)
	public Customer getCustomerDetailsAfterLogin(Authentication authentication) {
		
		Optional<Customer> customerOp = customerService.getDetailsPostLogin(authentication);
		return customerOp.isPresent()
				? customerOp.get() 
				: new Customer();
	}

	@GetMapping(Constants.GET_CUSTOMER_LIST)
	public ResponseEntity<List<Customer>> getCustomerList(
			@RequestParam(defaultValue = "0") int pageNumber,
			@RequestParam(defaultValue = "5") int pageSize,
			@RequestParam(defaultValue = "firstName") String field,
      @RequestParam(defaultValue = "ASC") Sort.Direction sortDirection) {

		List<Customer> customers = customerService.getCustomerList(pageNumber, pageSize, field, sortDirection);
		return (customers.size() > 0) 
				? ResponseEntity.status(HttpStatus.OK).body(customers)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body(customers);
	}

	@GetMapping(Constants.GET_CUSTOMER_BY_ID)
	public ResponseEntity<Customer> getCustomerById(@RequestParam Long id) {

		Optional<Customer> customerOp = customerService.getCustomerById(id);
		return (customerOp.isPresent()) 
				? ResponseEntity.status(HttpStatus.OK).body(customerOp.get())
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Customer());
	}

	@PostMapping(Constants.REGISTER_CUSTOMER)
	public ResponseEntity<String> addCustomer(@RequestBody CustomerDto dto) {

		return customerService.addCustomer(dto)
				? ResponseEntity.status(HttpStatus.CREATED).body("Customer created successfully.")
				: ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create customer.");
	}

	@GetMapping(Constants.GET_CUSTOMER_BY_EMAIL)
	public ResponseEntity<Customer> getCustomerByEmail(@RequestParam String email) {

		List<Customer> customers = customerService.getCustomerByEmail(email);
		return (customers.size()>0)
				? ResponseEntity.status(HttpStatus.OK).body(customers.get(0))
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Customer());
	}

	@DeleteMapping(Constants.DELETE)
	public ResponseEntity<String> deleteCustomer(@RequestParam long id) {

		return customerService.deleteCustomerById(id)
				? ResponseEntity.status(HttpStatus.OK).body("Failed to delete customer.")
				: ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Customer deleted successfully.");
	}
}
package com.invento.customer.dto;

import java.util.Set;

import com.invento.customer.model.Authority;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDto {

	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private long contact;
	
	private String email;
	
	private  String password;
	
	private AddressDto shippingAddress;
	
	private AddressDto billingAddress;
	
	private boolean shippingSABilling;
	
	private Set<Authority> authorities;
}

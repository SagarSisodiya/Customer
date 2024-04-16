package com.invento.customer.dto;

import java.util.Set;

import com.invento.customer.model.Authority;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AddressDto getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(AddressDto shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public AddressDto getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(AddressDto billingAddress) {
		this.billingAddress = billingAddress;
	}

	public boolean isShippingSABilling() {
		return shippingSABilling;
	}

	public void setShippingSABilling(boolean shippingSABilling) {
		this.shippingSABilling = shippingSABilling;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
}

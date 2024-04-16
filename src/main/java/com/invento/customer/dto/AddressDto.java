package com.invento.customer.dto;

public class AddressDto {

	private String flatHouseNo;
	
	private String street1;
	
	private String street2;
	
	private String state;
	
	private String postalCode;
	
	private String country;

	public String getFlatHouseNo() {
		return flatHouseNo;
	}

	public void setFlatHouseNo(String flatHouseNo) {
		this.flatHouseNo = flatHouseNo;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}

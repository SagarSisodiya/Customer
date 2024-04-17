package com.invento.customer.dto;

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
public class AddressDto {

	private String flatHouseNo;
	
	private String street1;
	
	private String street2;
	
	private String state;
	
	private String postalCode;
	
	private String country;
}

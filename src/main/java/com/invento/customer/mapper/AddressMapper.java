package com.invento.customer.mapper;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.invento.customer.dto.AddressDto;
import com.invento.customer.model.Address;

@Component
public class AddressMapper {

	public Address dtoToAddress(AddressDto dto) {

		Address address = new Address();
		if (Objects.nonNull(dto)) {
			address.setFlatHouseNo(dto.getFlatHouseNo());
			address.setStreet1(dto.getStreet1());
			address.setStreet2(dto.getStreet2());
			address.setState(dto.getState());
			address.setCountry(dto.getCountry());
			address.setPostalCode(dto.getPostalCode());
		}
		return address;
	}
}

package com.invento.customer.service.impl;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.invento.customer.dto.AddressDto;
import com.invento.customer.mapper.AddressMapper;
import com.invento.customer.model.Address;
import com.invento.customer.repository.AddressRepo;
import com.invento.customer.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	private AddressMapper addressMapper;

	private AddressRepo addressRepo;

	private static final Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);

	AddressServiceImpl(AddressMapper addressMapper, AddressRepo addressRepo) {

		this.addressMapper = addressMapper;
		this.addressRepo = addressRepo;
	}

	@Override
	public Address addAddress(AddressDto dto) {
		Address address = null;
		try {
			if (Objects.nonNull(dto)) {
				address = addressRepo.save(addressMapper.dtoToAddress(dto));
			} else {
				log.error("Address dto is null");
			}
		} catch (Exception e) {
			log.error("Failed to create address. Error: {}", e.getMessage());
		}
		return address;
	}

}

package com.invento.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invento.customer.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long>{

}

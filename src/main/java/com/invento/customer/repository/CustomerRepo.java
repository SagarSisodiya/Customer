package com.invento.customer.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.invento.customer.model.Customer;

@Repository
public interface CustomerRepo extends PagingAndSortingRepository<Customer, Long>, JpaRepository<Customer, Long>{
	
	@Query(value = "SELECT * FROM Customer WHERE email = ?1", nativeQuery=true)
	public Collection<Customer> findByAttribute(String value, String attr);
	
	List<Customer> findAllByDeleted(boolean deleted, Pageable pageable);
	
	List<Customer> findByEmail(String email);

	public Optional<Customer> findByIdAndDeleted(Long id, boolean b);
}

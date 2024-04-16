package com.invento.customer.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.invento.customer.model.Authority;
import com.invento.customer.model.Customer;
import com.invento.customer.repository.CustomerRepo;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {
	
	private CustomerRepo customerRepo;
	
	private PasswordEncoder passwordEncoder;
	
	public UserAuthenticationProvider(CustomerRepo customerRepo, PasswordEncoder passwordEncoder) {
		
		this.customerRepo = customerRepo;
		this.passwordEncoder = passwordEncoder;
	}
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws  AuthenticationException {
		String userName = authentication.getName();
		String pass = authentication.getCredentials().toString();
		List<Customer> customers = customerRepo.findByEmail(userName);
		if(customers.size()>0) {
			Customer customer = customers.get(0);
			if(passwordEncoder.matches(pass, customer.getPassword())) {

				return new UsernamePasswordAuthenticationToken(userName, pass, getGrantedAuthorities(customer.getAuthorities()));
			} else {
				throw new BadCredentialsException("Invalid username/password");
			}
		} else {
			throw new UsernameNotFoundException("User not found with username: " + userName);
		}
	}
	
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities){
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for(Authority authority: authorities) {
			grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
		}
		return grantedAuthorities;
	}
}

package com.invento.customer.filter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class AuthenticationLoggingFilter implements Filter {

	private static final Logger log = LoggerFactory.getLogger(AuthenticationLoggingFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			log.info("User " 
					+ authentication.getName() 
					+ " authenticated successfully with authorities: " 
					+ authentication.getAuthorities().toString());
		}
		filterChain.doFilter(request, response);
		
	}
}

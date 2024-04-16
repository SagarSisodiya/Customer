package com.invento.customer.util;

public class Constants {

	// Security
	public static final String JWT_KEY = "JDIwZGVkaWNhdGVkU2VjcmV0LjAyY3VzdG9tZXIlMjRsb2dpbkBrZXk=";
	public static final String JWT_HEADER = "Authorization";
	public static final String CSRF_REQUEST_ATTR_NAME = "_csrf";
	public static final String JWT_TOKEN =  "JWT TOKEN";
	
	// UI
	public static final String ANGULAR_LOCALHOST = "http://localhost:4200";
	
	// API Path
	public static final String CUSTOMER_ROOT = "/customer/**";
	public static final String CUSTOMER = "/customer";
	public static final String LOGIN = "/login";
	public static final String GET_CUSTOMER_LIST = "/getCustomerList";
	public static final String GET_CUSTOMER_BY_ID = "/getCustomerById";
	public static final String REGISTER_CUSTOMER = "/registerCustomer";
	public static final String GET_CUSTOMER_BY_EMAIL = "getCustomerByEmail";
	public static final String DELETE = "/delete";
	
	public static final String ADMIN = "ADMIN";
	public static final String ASTERISK = "*";
	public static final String INVENTO = "Invento";
	public static final String USERNAME = "username";
	public static final String AUTHORITIES = "authorities";
}

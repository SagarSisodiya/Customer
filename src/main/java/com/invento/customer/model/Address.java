package com.invento.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "flat_house_no")
	private String flatHouseNo;
	
	@Column(name = "street1")
	private String street1;
	
	@Column(name = "street2")
	private String street2;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	@Column(name = "country")
	private String country;
	
	@JsonIgnore
	@Column(name = "deleted")
	private boolean deleted;
	
	public Address() {
		super();
	}

	public Address(String flatHouseNo, String street1, String street2, String state, String postalCode, String country,
			boolean deleted) {
		super();
		this.flatHouseNo = flatHouseNo;
		this.street1 = street1;
		this.street2 = street2;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.deleted = deleted;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", flatHouseNo=" + flatHouseNo + ", street1=" + street1 + ", street2=" + street2
				+ ", state=" + state + ", postalCode=" + postalCode + ", country=" + country + ", deleted=" + deleted
				+ "]";
	}
}

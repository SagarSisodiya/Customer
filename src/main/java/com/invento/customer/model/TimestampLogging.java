package com.invento.customer.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;

public class TimestampLogging {

	@CreatedDate
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

	public TimestampLogging() {
		super();
	}

	public TimestampLogging(LocalDateTime createdDate, LocalDateTime updatedDate) {
		super();
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
}

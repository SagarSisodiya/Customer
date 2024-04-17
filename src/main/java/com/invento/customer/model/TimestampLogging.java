package com.invento.customer.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
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
public class TimestampLogging {

	@CreatedDate
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;
}

package com.test.recruitment.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Account entity
 * 
 * @author A525125
 *
 */
@Data
@Entity
@Table(name = "account")
public class Account implements Serializable {

	private static final long serialVersionUID = -3548441891975414771L;

	@Id
	private String id;
	@Column(nullable = false, length = 45)
	private String number;
	@Column(nullable = false, length = 45)
	private String type;
	@Column(nullable = false, length = 45)
	private BigDecimal balance;
	@Column(name = "created_at", nullable = false, length = 45)
	private Date creationDate;
	@Column(name = "is_active", nullable = false)
	private boolean isActive;
}

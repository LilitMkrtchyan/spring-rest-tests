package com.test.recruitment.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Transaction entity
 * 
 * @author A525125
 *
 */
@Data
@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 706690724306325415L;

	@Id
	private String id;
	@Column(name = "account_id", nullable = false)
	private String accountId;
	@Column(nullable = false, length = 45)
	private String number;
	@Column(nullable = false, length = 45)
	private BigDecimal balance;
}

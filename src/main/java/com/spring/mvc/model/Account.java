package com.spring.mvc.model;

import java.math.BigDecimal;

public final class Account {

	private final Integer id;

	private final String name;

	private final String type;

	private final BigDecimal balance;

	private final String openDate;

	private final String status;

	public Account(Integer id, String name, String type,

			BigDecimal balance, String openDate, String status) {

		this.id = id;

		this.name = name;

		this.type = type;

		this.balance = balance;

		this.openDate = openDate;

		this.status = status;

	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public String getOpenDate() {
		return openDate;
	}

	public String getStatus() {
		return status;
	}

}

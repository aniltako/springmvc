package com.spring.mvc.model;

public class AccountManager {

	public Account createAccoutn(){
		Account account = new AccountBuilder()
				           .withType("SAVING")
				           .withType("CHECKING")
				            .build();
		return account;

	}
}

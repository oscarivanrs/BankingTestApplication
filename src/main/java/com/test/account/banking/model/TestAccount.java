package com.test.account.banking.model;

import org.springframework.beans.factory.annotation.Value;

public class TestAccount extends Account{

	@Value("${accountId}")
    private String defaultAccountId;

    public TestAccount(String accountId) {
		super(accountId);
	}

    @Override
    public String getAccountId() {
        return defaultAccountId;
    }
}

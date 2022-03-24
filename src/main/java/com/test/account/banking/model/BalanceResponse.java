package com.test.account.banking.model;

public class BalanceResponse extends Response{
    
    @Override
    public AccountBalance getPayload() {
        return (AccountBalance) this.payload;
    }

    public void setPayload(AccountBalance payload) {
        this.payload = payload;
    }

}

package com.test.account.banking.model;

public class TransactionsResponse extends Response{
    
    @Override
    public TransactionsList getPayload() {
        return (TransactionsList) this.payload;
    }

    public void setPayload(TransactionsList payload) {
        this.payload = payload;
    }

}

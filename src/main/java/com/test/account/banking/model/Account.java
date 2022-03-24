package com.test.account.banking.model;

import java.util.ArrayList;
import java.util.List;

public class Account 
{
    protected String accountId;

    private List<Transaction> transactions = new ArrayList<>();

    public Account(String accountId){
        this.accountId = accountId;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public List<Transaction> getTransactions(){
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions){
        this.transactions = new ArrayList<>(transactions);
    }

    public void addTransactio(Transaction transaction)
    {
        if( transactions.indexOf(transaction)<0 )
            transactions.add(transaction);
    }
}

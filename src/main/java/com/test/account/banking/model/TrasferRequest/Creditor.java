package com.test.account.banking.model.TrasferRequest;

public class Creditor {
    private String name;
    private Account account;

    public Creditor(String name, Account account){
        this.name = name;
        this.account = account;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount(){
        return account;
    }

    public void setAccount(Account account){
        this.account = account;
    }
}

package com.test.account.banking.model.TrasferRequest;

public class Account {
    
    private String accountCode;
    private String bicCode;

    public Account(String accountCode, String bicCode){
        this.accountCode = accountCode;
        this.bicCode = bicCode;
    }
    
    public String getAccountCode()
    {
        return accountCode;
    }

    public void setAccountCode(String accountCode){
        this.accountCode = accountCode;
    }

    public String getBicCode() {
        return this.bicCode;
    }

    public void setBicCode(String bicCode) {
        this.bicCode = bicCode;
    }
}

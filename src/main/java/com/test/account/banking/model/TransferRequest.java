package com.test.account.banking.model;

import com.test.account.banking.model.TrasferRequest.Creditor;
import com.test.account.banking.util.Dates;

public class TransferRequest {
    
    private Creditor creditor;
    private String description;
    private Double amount;
    private String  currency;
    private String feeAccountId;

    public Creditor getCreditor() {
        return this.creditor;
    }

    public void setCreditor(Creditor creditor) {
        this.creditor = creditor;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFeeAccountId() {
        return this.feeAccountId;
    }

    public void setFeeAccountId(String feeAccountId) {
        this.feeAccountId = feeAccountId;
    }

    public String getExecutionDate(){
        return Dates.today();
    }

    public String toString()
    {
        return "{\"creditor\":{\"account\":{\"accountCode\":\""+getCreditor().getAccount().getAccountCode()+"\", \"bicCode\":\""+getCreditor().getAccount().getBicCode()+"\"}, \"name\":\""+getCreditor().getName()+"\"}, \"executionDate\":\""+getExecutionDate()+"\", \"feeAccountId\":\""+getFeeAccountId()+"\", \"description\":\""+getDescription()+"\", \"currency\":\""+getCurrency()+"\", \"amount\":\""+getAmount()+"\"}";
    }
}

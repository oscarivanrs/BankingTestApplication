package com.test.account.banking.model;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.account.banking.util.Dates;

public class Transaction {

    private final String transactionId;
    private final String operationId;
    private final Date accountingDate;
    private final Date valueDate;
    private final TransactionType type;
    private final Double amount;
    private final String currency;
    private final String description;

    public Transaction(@JsonProperty("transactionId") String transactionId, @JsonProperty("operationId") String operationId, @JsonProperty("accountingDate") String accountingDate, @JsonProperty("valueDate") String valueDate, @JsonProperty("type") TransactionType type, @JsonProperty("amount") String amount, @JsonProperty("currency") String currency, @JsonProperty("description") String description) {
        this.transactionId = transactionId;
        this.operationId = operationId;
        this.accountingDate = Dates.getDate(accountingDate);
        this.valueDate = Dates.getDate(valueDate);
        this.type = type;
        Double tmpAmount;
        try{
            tmpAmount = Double.parseDouble(amount);
        }catch(NumberFormatException e){
            tmpAmount = 0.0;
        }
        this.amount = tmpAmount;
        this.currency = currency;
        this.description = description;
    }

    public String getTransactionId(){
        return transactionId;
    }

    public String getOperationId(){
        return operationId;
    }

    public Date getAccountingDate(){
        return accountingDate;
    }

    public Date getValueDate() {
        return this.valueDate;
    }

    public TransactionType getType() {
        return this.type;
    }

    public Double getAmount() {
        return this.amount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString()
    {
        return "transactionId: " + transactionId + ", operationId: " + operationId + ", valueDate: " + valueDate + ", amount: " + amount;
    }
}

package com.test.account.banking.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionType {

    private final String enumeration;
    private final String value;

    public TransactionType(@JsonProperty("enumeration") String enumeration, @JsonProperty("value") String value) {
        this.enumeration = enumeration;
        this.value = value;
    }

    public String getEnumeration(){
        return this.enumeration;
    }

    public String getValue(){
        return this.value;
    }
}

package com.test.account.banking.model;

public class Response {
    
    protected String status;
    protected Error[] errors;
    protected Object payload;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Error[] getErrors() {
        return this.errors;
    }

    public void setErrors(Error[] errors) {
        this.errors = errors;
    }

    public Object getPayload() {
        return this.payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}

package com.test.account.banking.model;

public class Error {
    
    private String code;
    private String description;
    private String params;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParams() {
        return this.params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String toString(){
        return "code: " + code + ", description: " + description;
    }
}

package com.test.account.banking.model;

public class TransferResponse extends Response{
    
    @Override
    public TransferInfo getPayload() {
        return (TransferInfo) this.payload;
    }

    public void setPayload(TransferInfo payload) {
        this.payload = payload;
    }
}

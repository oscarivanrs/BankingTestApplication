package com.test.account.banking.model;

public class TransferInfo {

    private String moneyTransferId;
    private String status;
    private String direction;
    private Object creditor;
    private Object debtor;
    private String cro;
    private String uri;
    private String trn;
    private String description;
    private String createdDatetime;
    private String accountedDatetime;
    private String debtorValueDate;
    private String creditorValueDate;
    private Object amount;
    private String isUrgent;
    private String isInstant;
    private String feeType;
    private String feeAccountId;
    private Object fees;
    private String hasTaxRelief;

    public String getMoneyTransferId() {
        return this.moneyTransferId;
    }

    public void setMoneyTransferId(String moneyTransferId) {
        this.moneyTransferId = moneyTransferId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDirection() {
        return this.direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Object getCreditor() {
        return this.creditor;
    }

    public void setCreditor(Object creditor) {
        this.creditor = creditor;
    }

    public Object getDebtor() {
        return this.debtor;
    }

    public void setDebtor(Object debtor) {
        this.debtor = debtor;
    }

    public String getCro() {
        return this.cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getTrn() {
        return this.trn;
    }

    public void setTrn(String trn) {
        this.trn = trn;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedDatetime() {
        return this.createdDatetime;
    }

    public void setCreatedDatetime(String createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public String getAccountedDatetime() {
        return this.accountedDatetime;
    }

    public void setAccountedDatetime(String accountedDatetime) {
        this.accountedDatetime = accountedDatetime;
    }

    public String getDebtorValueDate() {
        return this.debtorValueDate;
    }

    public void setDebtorValueDate(String debtorValueDate) {
        this.debtorValueDate = debtorValueDate;
    }

    public String getCreditorValueDate() {
        return this.creditorValueDate;
    }

    public void setCreditorValueDate(String creditorValueDate) {
        this.creditorValueDate = creditorValueDate;
    }

    public Object getAmount() {
        return this.amount;
    }

    public void setAmount(Object amount) {
        this.amount = amount;
    }

    public String getIsUrgent() {
        return this.isUrgent;
    }

    public void setIsUrgent(String isUrgent) {
        this.isUrgent = isUrgent;
    }

    public String getIsInstant() {
        return this.isInstant;
    }

    public void setIsInstant(String isInstant) {
        this.isInstant = isInstant;
    }

    public String getFeeType() {
        return this.feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getFeeAccountId() {
        return this.feeAccountId;
    }

    public void setFeeAccountId(String feeAccountId) {
        this.feeAccountId = feeAccountId;
    }

    public Object getFees() {
        return this.fees;
    }

    public void setFees(Object fees) {
        this.fees = fees;
    }

    public String getHasTaxRelief() {
        return this.hasTaxRelief;
    }

    public void setHasTaxRelief(String hasTaxRelief) {
        this.hasTaxRelief = hasTaxRelief;
    }
}

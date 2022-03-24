package com.test.account.banking.dao;

import java.util.List;
import com.test.account.banking.model.Account;
import com.test.account.banking.model.Transaction;

public interface TransactionsDao {
    
    public String insertTransactionToDB(Account account, Transaction transaction);
    public String insertTransactionsToDB(Account account, List<Transaction> transactions);
}

package com.test.account.banking.service;

import java.util.List;
import com.test.account.banking.dao.TransactionsDao;
import com.test.account.banking.model.Account;
import com.test.account.banking.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TransactionsService {
    
    private final TransactionsDao transactionDao;

    @Autowired
    public TransactionsService(@Qualifier("oracleDB") TransactionsDao transactionsDao) {
        this.transactionDao = transactionsDao;
    }

    public String insertTransaction(Account account, Transaction transaction){
        return transactionDao.insertTransactionToDB(account, transaction);
    }

    public String insertTransactions(Account account, List<Transaction> transaction){
        return transactionDao.insertTransactionsToDB(account, transaction);
    }
}

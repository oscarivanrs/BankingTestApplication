package com.test.account.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import com.test.account.banking.model.Account;
import com.test.account.banking.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

@Repository("oracleDB")
public class OracleTransactionsService implements TransactionsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String insertTransactionToDB(Account account, Transaction transaction) {
		try{
			if( trxExist(transaction) )
				return "<li>TRX " + transaction.getTransactionId() + " <b>[ALREADY EXIST]</b></li>";
			int res = jdbcTemplate.update(getInsert(account, transaction));
			if( res>0 )
			{
				res = jdbcTemplate.update(getInsert(transaction));
				if( res>0 )
					return "<li>TRX " + transaction.getTransactionId() + " <b>[INSERTED]</b></li>";
				else
					return "<li>TRX " + transaction.getTransactionId() + " <b>[OPS]</b></li>";
			}
			else
				return "<li>TRX " + transaction.getTransactionId() + " <b>[OPS]</b></li>";
		}catch(Exception e){
			return "<li>TRX " + transaction.getTransactionId() + " <b>[EXCEPTION]</b></li>";
		}
	}

	@Override
	public String insertTransactionsToDB(Account account, List<Transaction> transaction) {
		StringBuilder result = new StringBuilder();
		result.append("<ul>");
		transaction.forEach( t -> result.append(insertTransactionToDB(account, t)));
		result.append("</ul>");
		return result.toString();
	}

	private PreparedStatementCreator getInsert(Transaction transaction) {
		return new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "INSERT INTO TRANSACTIONS (TRANSACTIONID, OPERATIONID, ACCOUNTINGDATE, VALUEDATE, TYPE, TYPE_VALUE, AMOUNT, CURRENCY, DESCRIPTION) VALUES (?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, transaction.getTransactionId());
				ps.setString(2, transaction.getOperationId());
				ps.setDate(3, new java.sql.Date(transaction.getAccountingDate().getTime()));
				ps.setDate(4, new java.sql.Date(transaction.getValueDate().getTime()));
				ps.setString(5, transaction.getType().getEnumeration());
				ps.setString(6, transaction.getType().getValue());
				ps.setDouble(7, transaction.getAmount());
				ps.setString(8, transaction.getCurrency());
				ps.setString(9, transaction.getDescription());
				return ps;
			}
		};
	}

	private PreparedStatementCreator getInsert(Account account, Transaction transaction) {
		return new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "INSERT INTO ACCOUNT_TRANSACTIONS (ACCOUNTID, TRANSACTIONID) VALUES (?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, account.getAccountId());
				ps.setString(2, transaction.getTransactionId());
				return ps;
			}
		};
	}

	private boolean trxExist(Transaction transaction){
		boolean exist = (jdbcTemplate.queryForObject("SELECT count(*) FROM ACCOUNT_TRANSACTIONS WHERE TRANSACTIONID = '" + transaction.getTransactionId() + "'", Integer.class))>0;
		if( !exist )
			exist = (jdbcTemplate.queryForObject("SELECT count(*) FROM TRANSACTIONS WHERE TRANSACTIONID = '" + transaction.getTransactionId() + "'", Integer.class))>0;
		return exist;
	}
}

package com.qsoft.bankaccount.business;

import com.qsoft.bankaccount.persistence.dao.TransactionDAO;
import com.qsoft.bankaccount.persistence.model.TransactionEntity;

import java.util.Calendar;
import java.util.List;

/**
 * User: thanhtd
 * Date: 06/07/2013
 * Time: 00:50
 */
public interface TransactionService
{
    List<TransactionEntity> getTransactionsOccurred(String accountNumber);

    List<TransactionEntity> getTransactionsOccurred(String accountNumber, long startTime, long stopTime);

    List<TransactionEntity> getTransactionsOccurred(String accountNumber, int n);

    void createTransaction(String accountNumber, int amount, String description);

    void setTransactionDao(TransactionDAO transactionDao);

    void setCalendar(Calendar mockCalendar);
}

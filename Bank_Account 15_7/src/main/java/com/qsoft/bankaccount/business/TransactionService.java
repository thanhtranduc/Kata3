package com.qsoft.bankaccount.business;

import java.util.Calendar;
import java.util.List;

/**
 * User: thanhtd
 * Date: 17/07/2013
 * Time: 00:28
 */
public interface TransactionService
{
    List<TransactionEntity> getTransactionsOccurred(String accountNumber);

    List<TransactionEntity> getTransactionsOccurred(String accountNumber, long startTime, long stopTime);

    List<TransactionEntity> getTransactionsOccurred(String accountNumber, int n);

    void createTransaction(String accountNumber, int amount, String description);

    void setDao(TransactionDAO mockTransactionDao);

    void setTransactionDao(TransactionDAO transactionDao);

    void setCalendar(Calendar mockCalendar);
}

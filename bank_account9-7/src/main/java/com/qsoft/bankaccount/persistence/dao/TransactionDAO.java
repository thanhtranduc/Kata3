package com.qsoft.bankaccount.persistence.dao;

import com.qsoft.bankaccount.persistence.model.TransactionEntity;

import java.util.List;

/**
 * User: thanhtd
 * Date: 06/07/2013
 * Time: 00:57
 */
public interface TransactionDAO
{
    void save(TransactionEntity transactionEntity);

    List<TransactionEntity> getTransactionsOccurred(String accountNumber);
    List<TransactionEntity> getTransactionsOccurred(String accountNumber, long starTime, long stopTime);
    List<TransactionEntity> getTransactionsOccurred(String accountNumber, int n);
}

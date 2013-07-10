package com.qsoft.bankaccount.business.impl;

import com.qsoft.bankaccount.business.TransactionService;
import com.qsoft.bankaccount.persistence.dao.TransactionDAO;
import com.qsoft.bankaccount.persistence.model.TransactionEntity;

import java.util.Calendar;
import java.util.List;

/**
 * User: thanhtd
 * Date: 06/07/2013
 * Time: 00:51
 */
public class TransactionServiceImpl implements TransactionService
{
    private static TransactionDAO transactionDao;
    private static Calendar calendar;

    public static void save(String accountNumber, long amount, String description)
    {

        Long timeStamp = calendar.getTimeInMillis();

        TransactionEntity transactionEntity = new TransactionEntity(accountNumber,timeStamp,amount,description);
        transactionDao.save(transactionEntity);
    }

    @Override
    public void setTransactionDao(TransactionDAO transactionDao)
    {
        TransactionServiceImpl.transactionDao = transactionDao;
    }

    @Override
    public void setCalendar(Calendar mockCalendar)
    {
        TransactionServiceImpl.calendar = mockCalendar;
    }
    @Override
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber)
    {
        return transactionDao.getTransactionsOccurred(accountNumber);
    }

    @Override
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber, long startTime, long stopTime)
    {
        return transactionDao.getTransactionsOccurred(accountNumber,startTime,stopTime);
    }

    @Override
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber, int n)
    {
        return transactionDao.getTransactionsOccurred(accountNumber,n);
    }

    @Override
    public void createTransaction(String accountNumber, int amount, String description)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setDao(TransactionDAO mockTransactionDao)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

}

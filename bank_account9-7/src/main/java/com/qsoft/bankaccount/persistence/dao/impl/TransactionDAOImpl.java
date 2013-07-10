package com.qsoft.bankaccount.persistence.dao.impl;

import com.qsoft.bankaccount.persistence.dao.TransactionDAO;
import com.qsoft.bankaccount.persistence.model.TransactionEntity;

import java.util.List;

/**
 * User: thanhtd
 * Date: 06/07/2013
 * Time: 00:53
 */
public class TransactionDAOImpl implements TransactionDAO
{
//    @PersistenceContext
//    private EntityManager entityManager;

    @Override
    public void save(TransactionEntity transactionEntity)
    {
      //  entityManager.persist(transactionEntity);
    }

    @Override
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber)
    {
       return null;// Query query = entityManager.createQuery("select o from TransactionEntity o where o.accountNumber = :qAccountNumber", TransactionEntity.class);
    }

    @Override
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber, long starTime, long stopTime)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber, int n)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

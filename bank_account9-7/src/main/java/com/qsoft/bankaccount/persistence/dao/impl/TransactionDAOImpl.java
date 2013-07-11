package com.qsoft.bankaccount.persistence.dao.impl;

import com.qsoft.bankaccount.persistence.dao.TransactionDAO;
import com.qsoft.bankaccount.persistence.model.TransactionEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * User: thanhtd
 * Date: 06/07/2013
 * Time: 00:53
 */
public class TransactionDAOImpl implements TransactionDAO
{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(TransactionEntity transactionEntity)
    {
        entityManager.persist(transactionEntity);
    }

    @Override
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber)
    {
       Query query = entityManager.createQuery("select o from TransactionEntity o where o.account_Number = :qAccountNumber",TransactionEntity.class);
       query.setParameter("qAccountNumber",accountNumber);
       return query.getResultList();
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

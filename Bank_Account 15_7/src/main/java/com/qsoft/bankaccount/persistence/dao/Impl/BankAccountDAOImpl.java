package com.qsoft.bankaccount.persistence.dao.Impl;

import com.qsoft.bankaccount.persistence.dao.BankAccountDAO;
import com.qsoft.bankaccount.persistence.model.BankAccountEntity;

import javax.management.Query;
import java.util.List;

/**
 * User: thanhtd
 * Date: 17/07/2013
 * Time: 00:33
 */
@Transactional
@Component
public class BankAccountDAOImpl implements BankAccountDAO
{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BankAccountEntity getAccount(String accountNumber)
    {
        Query query = entityManager.createQuery("select o from BankAccountEntity o where o.accountNumber = :qAccountNumber", BankAccountEntity.class);
        query.setParameter("qAccountNumber", accountNumber);
        List<BankAccountEntity> list = query.getResultList();
        if (list.size() == 0)
        {
            return null;
        }
        else
        {
            return list.get(0);
        }
    }

    @Override
    public void add()
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void save(BankAccountEntity bankAccountEntity)
    {
        entityManager.persist(bankAccountEntity);
        entityManager.flush();
    }


}

package com.qsoft.bankaccount.persistence.dao;

import com.qsoft.bankaccount.persistence.model.BankAccountEntity;

/**
 * User: thanhtd
 * Date: 17/07/2013
 * Time: 00:32
 */
public interface BankAccountDAO
{
    public BankAccountEntity getAccount(String accountNumber);
    void save(BankAccountEntity bankAccountEntity);
}

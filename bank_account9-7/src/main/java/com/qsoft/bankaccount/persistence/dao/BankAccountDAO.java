package com.qsoft.bankaccount.persistence.dao;

import com.qsoft.bankaccount.persistence.model.BankAccountEntity;

/**
 * User: thanhtd
 * Date: 06/07/2013
 * Time: 00:57
 */
public interface BankAccountDAO
{
    public BankAccountEntity getAccount(String accountNumber);

    void add();

    void save(BankAccountEntity bankAccountEntity);
}

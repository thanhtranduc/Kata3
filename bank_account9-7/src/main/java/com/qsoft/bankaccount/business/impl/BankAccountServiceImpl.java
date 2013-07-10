package com.qsoft.bankaccount.business.impl;

import com.qsoft.bankaccount.business.BankAccountService;
import com.qsoft.bankaccount.persistence.dao.BankAccountDAO;
import com.qsoft.bankaccount.persistence.model.BankAccountEntity;

/**
 * User: thanhtd
 * Date: 06/07/2013
 * Time: 00:51
 */
public class BankAccountServiceImpl implements BankAccountService
{
    private static BankAccountDAO bankAccountDao;

    public BankAccountEntity openAccount(String accountNumber) throws Exception
    {
        BankAccountEntity newAccDTO = new BankAccountEntity(accountNumber);
        bankAccountDao.save(newAccDTO);
        return newAccDTO;

    }

    @Override
    public BankAccountEntity getAccount(String accountNumber) throws Exception
    {
        return null;
    }

    public void setBankAccountDao(BankAccountDAO mockAccountDao) {
        BankAccountServiceImpl.bankAccountDao = mockAccountDao;
    }

    public void deposit(String accountNumber, long amount, String description) throws Exception
    {
        doTransaction(accountNumber,amount, description);
    }

    private static void doTransaction(String accountNumber, long amount, String description) throws Exception
    {

        BankAccountEntity bankAccountEntity = bankAccountDao.getAccount(accountNumber);

        bankAccountEntity.setBalance(bankAccountEntity.getBalance() + amount);

        bankAccountDao.save(bankAccountEntity);

        TransactionServiceImpl.save(accountNumber, amount, description);

    }

    public void withdraw(String accountNumber, long amount, String description) throws Exception
    {
        doTransaction(accountNumber, -amount, description);
    }


}

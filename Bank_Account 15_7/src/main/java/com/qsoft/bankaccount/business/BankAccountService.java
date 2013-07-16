package com.qsoft.bankaccount.business;

/**
 * User: thanhtd
 * Date: 17/07/2013
 * Time: 00:28
 */
public interface BankAccountService
{
    public void setBankAccountDao(BankAccountDAO mockAccountDao);

    public BankAccountEntity openAccount(String accountNumber) throws Exception;

    public BankAccountEntity getAccount(String accountNumber) throws Exception;

    public void deposit(String accountNumber, long amount, String description) throws Exception;

    public void withdraw(String accountNumber, long amount, String description) throws Exception;
}

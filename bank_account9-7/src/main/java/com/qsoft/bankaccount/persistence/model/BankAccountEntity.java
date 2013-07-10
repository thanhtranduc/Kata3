package com.qsoft.bankaccount.persistence.model;

import javax.persistence.*;
import java.util.Calendar;

/**
 * User: thanhtd
 * Date: 06/07/2013
 * Time: 00:55
 */
@Entity
@Table(name = "bank_account")
@SequenceGenerator(name = "seq_id1", sequenceName = "seq_id1", initialValue = 1, allocationSize = 1)
public class BankAccountEntity
{
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_id1")
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "balance")
    private double balance;

    @Column(name = "open_time_stamp")
    long openTimeStamp;

    private static Calendar calendar = Calendar.getInstance();

    public BankAccountEntity(String accountNumber, double balance, long openTimeStamp)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.openTimeStamp = openTimeStamp;
    }

    public BankAccountEntity(String accountNumber, double balance)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.openTimeStamp = calendar.getTimeInMillis();
    }

    public BankAccountEntity()
    {
    }

    public BankAccountEntity(String accountNumber)
    {
        this.accountNumber = accountNumber;
        this.balance = 0;
        openTimeStamp = calendar.getTimeInMillis();
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public long getOpenTimeStamp()
    {
        return openTimeStamp;
    }

    public void setOpenTimeStamp(long openTimeStamp)
    {
        this.openTimeStamp = openTimeStamp;
    }

    public static Calendar getCalendar()
    {
        return calendar;
    }

    public static void setCalendar(Calendar calendar)
    {
        BankAccountEntity.calendar = calendar;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }
}
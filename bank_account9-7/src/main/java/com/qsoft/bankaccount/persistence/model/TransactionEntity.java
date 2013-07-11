package com.qsoft.bankaccount.persistence.model;

import javax.persistence.*;
import java.util.Calendar;

/**
 * User: thanhtd
 * Date: 06/07/2013
 * Time: 00:58
 */

@Entity
@Table(name = "transaction")
@SequenceGenerator(name ="seq_id",sequenceName = "seq_id",initialValue = 1, allocationSize = 1)
public class TransactionEntity
{
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_id")
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "account_number")
    private String account_Number;
    @Column(name = "amount")
    private double amount;
    @Column(name ="open_time_stamp")
    private long openTimeStamp;
    @Column(name = "description")
    private String description;


    private static Calendar calendar = Calendar.getInstance();

    public TransactionEntity(String accountNumber, double amount, String description)
    {
        this.account_Number = accountNumber;
        this.description = description;
        this.amount = amount;
        this.openTimeStamp = calendar.getTimeInMillis();
    }

    public TransactionEntity(String accountNumber, long openTimeStamp, double amount, String description)
    {
        this.account_Number = accountNumber;
        this.description = description;
        this.amount = amount;
        this.openTimeStamp = openTimeStamp;
    }

    public TransactionEntity()
    {
    }


    public String getAccountNumber()
    {
        return account_Number;
    }

    public void setAccountNumber(String accountNumber)
    {
        this.account_Number = accountNumber;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public long getOpenTimeStamp()
    {
        return openTimeStamp;
    }

    public void setOpenTimeStamp(long openTimeStamp)
    {
        this.openTimeStamp = openTimeStamp;
    }

    public Calendar getCalendar()
    {
        return calendar;
    }

    public static void setCalendar(Calendar calendar)
    {
        TransactionEntity.calendar = calendar;
    }
}

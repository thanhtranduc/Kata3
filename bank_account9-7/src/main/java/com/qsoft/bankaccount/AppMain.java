package com.qsoft.bankaccount;

import com.qsoft.bankaccount.persistence.dao.BankAccountDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: thanhtd
 * Date: 06/07/2013
 * Time: 00:49
 */
public class AppMain
{
    public static void main(String[] args)
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        BankAccountDAO bankAccountDAO = (BankAccountDAO) appContext.getBean("bankAccountDAO");
//        bankAccountDAO.add();

    }
}

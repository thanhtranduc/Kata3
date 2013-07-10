package bankaccount.persistence.dao;

import com.qsoft.bankaccount.persistence.dao.BankAccountDAO;
import com.qsoft.bankaccount.persistence.model.BankAccountEntity;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import static org.junit.Assert.assertEquals;

/**
 * User: thanhtd
 * Date: 06/07/2013
 * Time: 01:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testContext.xml"})
@TransactionConfiguration(defaultRollback = true)

@Transactional
public class TestBankAccountDAO
{
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private BankAccountDAO bankAccountDAO;
    final static String accountNumber = "1234567890";
    final static double e = 0.01;
    @Autowired
    private DataSource dataSource;

    private IDatabaseTester databaseTester;

    @Before
    public void setup() throws Exception
    {
        IDataSet dataSet = readDataSet();  // read data from xml file
        cleanlyInsert(dataSet);  // empty the db and insert data
    }

    private IDataSet readDataSet() throws Exception
    {
        return new FlatXmlDataSetBuilder().build(System.class.getResource("/dataset.xml"));
    }

    private void cleanlyInsert(IDataSet dataSet) throws Exception
    {
        databaseTester = new DataSourceDatabaseTester(dataSource);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }

    @After
    public void tearDown() throws Exception
    {
        databaseTester.onTearDown();
    }

    @Test
    public void testGetAccount() throws Exception
    {
        // BankAccountDAO bankAccountDAO = new BankAccountDAOImpl();   oi con lay me. :(( mat het ca buoi toi cua con :((
        BankAccountEntity account = bankAccountDAO.getAccount(accountNumber);
        System.out.println("thanhtran");

        assertEquals("1234567890", account.getAccountNumber());
        assertEquals(100, account.getBalance(), 0.01);
        assertEquals(12345678, account.getOpenTimeStamp());
    }

    @Test
    public void testGetNotExistAccountThenReturnNull()
    {
        BankAccountEntity account = bankAccountDAO.getAccount("1111111111");
        assertEquals(account, null);
    }

    @Test
    public void testSaveSuccessExistingBankAccount()
    {
        BankAccountEntity account = bankAccountDAO.getAccount(accountNumber);
        account.setBalance(1000);
        bankAccountDAO.save(account);

        entityManager.detach(account);
        BankAccountEntity accountAfterSave = bankAccountDAO.getAccount(accountNumber);

        assertEquals(accountAfterSave.getAccountNumber(), accountNumber);
        assertEquals(accountAfterSave.getBalance(), 1000, e);
    }

    @Test
    public void testSaveNewAccount()
    {
        BankAccountEntity account = new BankAccountEntity(accountNumber,100);
        account.setBalance(100);
        bankAccountDAO.save(account);


        BankAccountEntity accountAfter = bankAccountDAO.getAccount(accountNumber);

        assertEquals(accountAfter.getAccountNumber(), accountNumber);
        assertEquals(accountAfter.getBalance(), 100, e);
    }


}

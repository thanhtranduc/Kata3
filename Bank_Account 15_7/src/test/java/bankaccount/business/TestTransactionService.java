package bankaccount.business;

import com.qsoft.bankaccount.business.BankAccountService;
import com.qsoft.bankaccount.business.TransactionService;
import com.qsoft.bankaccount.persistence.dao.Impl.BankAccountDAOImpl;
import com.qsoft.bankaccount.persistence.dao.Impl.TransactionDAOImpl;

import java.util.Calendar;
import java.util.List;

/**
 * User: thanhtd
 * Date: 17/07/2013
 * Time: 00:26
 */
public class TestTransactionService
{
    BankAccountDAOImpl mockAccountDao = mock(BankAccountDAOImpl.class);
    BankAccountService bankAccountService = new BankAccountServiceImpl();
    TransactionService transactionService = new TransactionServiceImpl();
    TransactionDAOImpl transactionDao = mock(TransactionDAOImpl.class);
    Calendar mockCalendar = mock(Calendar.class);
    private String accountNumber = "1234567890";

    @Before
    public void setUp()
    {
        reset(mockAccountDao);
        bankAccountService.setBankAccountDao(mockAccountDao); //gia lap thang bankAccountDAO cho tang service
        transactionService.setTransactionDao(transactionDao);   //gia lap thang transaction tang DAO cho tang service
        transactionService.setCalendar(mockCalendar);  //gia lap thang DAO calendar cho tang service
    }

    @Test
    public void testGetTransactionOccurred() throws Exception
    {
        List<TransactionEntity> list = transactionService.getTransactionsOccurred(accountNumber);
    }
    @Test
    public void testGetTransactionsOccurredDifferenceTime() throws Exception
    {
        long starTime = 100;
        long endTime = 1000;
        List<TransactionEntity> list = transactionService.getTransactionsOccurred(accountNumber, starTime, endTime);
    }
    @Test
    public void testNTransaction() throws Exception
    {
        int n = 2;
        List<TransactionEntity> list = transactionService.getTransactionsOccurred(accountNumber, n);
    }
}

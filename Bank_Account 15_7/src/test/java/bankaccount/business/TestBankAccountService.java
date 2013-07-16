package bankaccount.business;

import com.qsoft.bankaccount.business.BankAccountService;
import com.qsoft.bankaccount.business.Impl.BankAccountServiceImpl;
import com.qsoft.bankaccount.business.Impl.TransactionServiceImpl;
import com.qsoft.bankaccount.persistence.dao.BankAccountDAO;
import com.qsoft.bankaccount.persistence.dao.TransactionDAO;
import com.qsoft.bankaccount.persistence.model.BankAccountEntity;

import java.util.Calendar;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * User: thanhtd
 * Date: 17/07/2013
 * Time: 00:23
 */
public class TestBankAccountService
{
    BankAccountDAO mockAccountDao = mock(BankAccountDAO.class);      //tao mock cho tang DAO
    TransactionDAO transactionDao = mock(TransactionDAO.class);       // Tao mock cho tang DAO
    Calendar mockCalendar = mock(Calendar.class);  // mock calendar cho tang DAO
    BankAccountService bankAccountServiceImpl = new BankAccountServiceImpl();
    TransactionServiceImpl transactionServiceImpl = new TransactionServiceImpl();

    private String accountNumber = "1234567890";

    @Before
    public void setUp()
    {
        reset(mockAccountDao);
        reset(mockCalendar);
        bankAccountServiceImpl.setBankAccountDao( mockAccountDao);  //set account DAO cho tang service
        transactionServiceImpl.setTransactionDao(transactionDao);
        transactionServiceImpl.setCalendar(mockCalendar);

    }

    @Test
    public void testCreateNewAccountHasBalanceZero() throws Exception
    {
        ArgumentCaptor<BankAccountEntity> argumentCaptor = ArgumentCaptor.forClass(BankAccountEntity.class);
        BankAccountEntity.setCalendar(mockCalendar);
        when(mockCalendar.getTimeInMillis()).thenReturn(1000L);

        BankAccountEntity newAcc = bankAccountServiceImpl.openAccount(accountNumber);
        verify(mockAccountDao).save(argumentCaptor.capture());

        assertEquals(accountNumber, argumentCaptor.getValue().getAccountNumber());
        assertEquals(argumentCaptor.getValue().getBalance(), 0, 0.01);
        assertEquals(argumentCaptor.getValue().getOpenTimeStamp(), 1000L);
    }

    @Test
    public void testDepositBalanceAccount() throws Exception
    {
        BankAccountEntity newAcc = bankAccountServiceImpl.openAccount(accountNumber);

        when(mockAccountDao.getAccount(accountNumber)).thenReturn(newAcc);  //do getAccount tang DAO chua ton tai ta phai gia lap mong muon no tra ve newAcc

        bankAccountServiceImpl.deposit(accountNumber, 1000, "deposit");

        ArgumentCaptor<BankAccountEntity> argumentCaptor = ArgumentCaptor.forClass(BankAccountEntity.class);
        verify(mockAccountDao, times(2)).save(argumentCaptor.capture());
        List<BankAccountEntity> saveRecord = argumentCaptor.getAllValues();
        assertEquals(saveRecord.get(1).getBalance(), 1000, 0.01);
    }

    @Test
    public void testWithdrawBalanceAccount() throws Exception
    {
        BankAccountEntity accountDTO = bankAccountServiceImpl.openAccount("1234567890");
        when(mockAccountDao.getAccount("1234567890")).thenReturn(accountDTO);
        bankAccountServiceImpl.deposit("1234567890", 1000, "deposit");
        bankAccountServiceImpl.withdraw("1234567890", 500, "deposit");
        ArgumentCaptor<BankAccountEntity> argumentAccount = ArgumentCaptor.forClass(BankAccountEntity.class);
        verify(mockAccountDao, times(3)).save(argumentAccount.capture());
        List<BankAccountEntity> savedAccountDB = argumentAccount.getAllValues();
        Assert.assertEquals(savedAccountDB.get(1).getBalance(), 500, 0.01);
    }
}

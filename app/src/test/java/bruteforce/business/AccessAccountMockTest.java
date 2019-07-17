package bruteforce.business;

import org.junit.Before;
import org.junit.Test;

import bruteforce.objects.Account;

import bruteforce.persistence.AccountPersistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

/**
 Class: AccessAccountMockTest
 Author: Yunpeng Zhong
 Purpose: Add more mock test to cover all of AccessAccount Class
 */
public class AccessAccountMockTest {
    private AccessAccount accessAccount;
    private AccountPersistence accountPersistence;

    @Before
    public void setUp(){
        accountPersistence = mock(AccountPersistence.class);
        accessAccount = new AccessAccount(accountPersistence);
    }

    /**
     * testCheckLogin
     * <p>
     * Purpose: test checkLogin method in the AccessAccount class
     * Parameters: none
     * Returns: none, must print out finished to pass the test
     */
    @Test
    public void testCheckLogin(){
        final Account account;
        account = new Account("username1", "password1", 0 , 10,0 );
        System.out.println("\nStarting testCheckLogin");
        when(accountPersistence.getAccount("username1")).thenReturn(account);
        accessAccount.getAccount("username1");
        assertTrue("Login in with the right username and password should return true",accessAccount.checkLogin("username1","password1"));
        assertFalse("Login in with the wrong username should return true",accessAccount.checkLogin("username5","password1"));
        assertFalse("Login in with the wrong password should return true",accessAccount.checkLogin("username1","password2"));
        verify(accountPersistence,times(3)).getAccount("username1");
        System.out.println("Finished testCheckLogin");
    }

    /**
     * testUpdatePlant
     * <p>
     * Purpose: test updatePlant method in the AccessAccount class
     * Parameters: none
     * Returns: none, must print out finished to pass the test
     */
    @Test
    public void testUpdatePlant(){
        final Account account;
        account = new Account("username1", "password1", 0 , 10,0 );
        when(accountPersistence.getAccount("username1")).thenReturn(account);
        when(accountPersistence.updateAccount(account)).thenReturn(true);
        System.out.println("\nStarting testUpdatePlant");
        accessAccount.getAccount("username1");
        accessAccount.updatePlant(50,3);
        account.setPlant(50,3);
        accessAccount.getAccount("username1");
        assertEquals("The water level should be 50",50, accessAccount.getCurrentAccount().getPlant().getWaterLevel());
        assertEquals("The growth level should be 50",3, accessAccount.getCurrentAccount().getPlant().getGrowthLevel());
        verify(accountPersistence).updateAccount(account);
        verify(accountPersistence,times(2)).getAccount("username1");
        System.out.println("Finished testUpdatePlant");
    }
}

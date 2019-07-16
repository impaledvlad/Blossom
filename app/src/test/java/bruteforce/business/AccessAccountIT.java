package bruteforce.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import bruteforce.objects.Account;
import bruteforce.persistence.AccountPersistence;
import bruteforce.persistence.hsqldb.AccountPersistenceHSQLDB;
import bruteforce.utils.TestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class AccessAccountIT {
    private AccessAccount accessAccount;
    private File tempDB;


    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final AccountPersistence persistence = new AccountPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessAccount = new AccessAccount(persistence);
    }

    /**
     * testGetCurrentAccount
     * <p>
     * Purpose: test getCurrentAccount method in the AccessAccount class
     * Parameters: none
     * Returns: none, must print out finished to pass the test
     */
    @Test
    public void testGetCurrentAccount() {

        accessAccount.getAccount("username1");
        Account expectAccount = new Account("username1", "password1");

        System.out.println(expectAccount.getUsername());

        assertEquals("The Account should be equal", expectAccount.getUsername(), accessAccount.getCurrentAccount().getUsername());
        accessAccount.getAccount("username4");
        assertNull("When the Account not in the database it should return null", accessAccount.getCurrentAccount());

        System.out.println("Finished testGetCurrentAccount");

    }

    /**
     * testGetAccount
     * <p>
     * Purpose: test getAccount method in AccessAccount class
     * Parameters: none
     * Returns: none, must print out finished to pass the test
     */
    @Test
    public void testGetAccount() {
        accessAccount.getAccount("username4");
        Account expectAccount = new Account("username1", "password1");
        System.out.println("\nStarting testGetAccount");

        assertNull("The current Account should be null if no account found", accessAccount.getCurrentAccount());
        accessAccount.getAccount("username1");
        assertEquals("Current account shold be usename1 account", expectAccount.getUsername(), accessAccount.getCurrentAccount().getUsername());

        System.out.println("Finished testGetAccount");
    }

    /**
     * testInsertAccount
     * <p>
     * Purpose: test insertAccount method in the AccessAccount
     * Parameters: none
     * Returns: none, must print out finished to pass the test
     */
    @Test
    public void testInsertAccount() {
        accessAccount.getAccount("username1");
        Account newAccount = new Account("username5", "password5");
        accessAccount.insertAccount(newAccount);
        accessAccount.getAccount("username5");
        System.out.println("\nStarting testInsertAccount");

        assertEquals("The current account should be the newAccount", newAccount.getUsername(), accessAccount.getCurrentAccount().getUsername());

        System.out.println("Finished testInsertAccount");
    }

    /**
     * testUpdatePoints
     * <p>
     * Purpose: test updatePoints method in the AccessAccount
     * Parameters: none
     * Returns: none, must print out finished to pass the test
     */
    @Test
    public void testUpdatePoints() {
        accessAccount.getAccount("username1");
        accessAccount.updatePoints(3);
        System.out.println("\nStarting testUpdatePoints");

        assertEquals("the new points for username1 should be 3", 3, accessAccount.getCurrentAccount().getPoints());

        System.out.println("Finished testUpdatePoints");
    }

    /**
     * testUpdatePassword
     * <p>
     * Purpose: test updatePassword method in the AccessAccount
     * Parameters: none
     * Returns: none, must print out finished to pass the test
     */
    @Test
    public void testUpdatePassword() {
        accessAccount.getAccount("username1");
        accessAccount.updatePassword("newPassword");
        System.out.println("\nStarting testUpdatePoints");

        assertEquals("the new password for username1 should be newPassword", "newPassword", accessAccount.getCurrentAccount().getPassword());

        System.out.println("Finished testUpdatePoints");
    }

    /**
     * testUpdateAccount()
     * <p>
     * Purpose: test updateAccount method in the AccessAccount
     * Parameters: none
     * Returns: none, must print out finished to pass the test
     */
    @Test
    public void testUpdateAccount() {
        accessAccount.getAccount("username1");
        accessAccount.updatePoints(4);
        accessAccount.updatePassword("newPassword1");
        accessAccount.updateAccount();
        System.out.println("\nStarting testUpdateAccount");

        accessAccount.getAccount("username1");
        assertEquals("the new points for username1 should be 4", 4, accessAccount.getCurrentAccount().getPoints());
        assertEquals("the new password for username1 should be newPassword1", "newPassword1", accessAccount.getCurrentAccount().getPassword());

        System.out.println("Finished testUpdateAccount");
    }

    /**
     * testLogOut
     * <p>
     * Purpose: test logOut method in access account
     * Parameters: none
     * Returns: none, must print out finished to pass the test
     */
    @Test
    public void testLogOut() {
        accessAccount.getAccount("username1");
        System.out.println("\nStarting testLogOut");

        assertNotNull("Before user logout the current account, the current should  not be null",accessAccount.getCurrentAccount());
        accessAccount.logOut();
        assertNull("When user logout the current account, the current should be null",accessAccount.getCurrentAccount());

        System.out.println("Finished testLogOut");
    }

    /**
     * testDeleteAccount
     * <p>
     * Purpose: test deleteAccount method in the AccessAccount
     * Parameters: none
     * Returns: none, must print out finished to pass the test
     */
    @Test
    public void testDeleteAccount() {

        System.out.println("\nStarting testDeleteAccount");

        accessAccount.getAccount("username2");
        assertNotNull("When the account doesn't delete, the current account should not be null", accessAccount.getCurrentAccount());
        accessAccount.deleteAccount();
        accessAccount.getAccount("username2");
        assertNull("When the account delete the current account should be null", accessAccount.getCurrentAccount());

        System.out.println("Finished testDeleteAccount");
    }
    @After
    public void tearDown() {
        this.tempDB.delete();
    }
}

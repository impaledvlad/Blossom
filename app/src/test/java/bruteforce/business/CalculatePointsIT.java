package bruteforce.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import bruteforce.objects.Account;
import bruteforce.persistence.AccountPersistence;
import bruteforce.persistence.TaskPersistence;
import bruteforce.persistence.hsqldb.AccountPersistenceHSQLDB;
import bruteforce.persistence.hsqldb.TaskPersistenceHSQLDB;
import bruteforce.utils.TestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CalculatePointsIT {
    private AccessAccount accessAccount;
    private AccessTask accessTask;
    private File tempDB;

    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final AccountPersistence accountPersistence = new AccountPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessAccount = new AccessAccount(accountPersistence);
        final TaskPersistence taskPersistence = new TaskPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessTask = new AccessTask(taskPersistence,"username1");
    }

    /**
     * testConstructor
     * <p>
     * Purpose: test to see if constructor is initialied correctly.
     * Parameters: none
     * Returns: none
     */

    @Test
    public void testConstructor() {

        System.out.println("\nStarting testConstructor");


        // Create AccessAcount object..
        accessAccount.getAccount("username1");

        accessAccount.updatePoints(50);

        CalculatePoints testConstructor0;

        testConstructor0 = new CalculatePoints(accessAccount, accessTask, "username1");

        accessTask.getTask(1);


        assertNotNull("The award points constructor has failed to initialize.", testConstructor0);

        System.out.println("Finished testConstructor.");

    }


    /**
     * testAwardPoints
     * <p>
     * Purpose: Test to see if points are assigned correctly upon completing task
     * Parameters: none
     * Returns: none
     */

    @Test
    public void testAwardPoints() {

        System.out.println("\nStarting testAwardPoints");


        // Create AccessAcount object..
        accessAccount.getAccount("username1");

        accessAccount.updatePoints(50);

        accessTask.getTask(1);
        accessAccount.updatePoints(50);

        // Creates a CalculatePoints object.
        CalculatePoints testConstructor1 = new CalculatePoints(accessAccount, accessTask, "username1");

        // get the value of points rewarded.
        int value = testConstructor1.awardPoints();

        // Get the current user from the database
        Account checkDB = accessAccount.getCurrentAccount();

        //check to see if current user information has updated correctly to the DB.
        assertEquals("The awardPoints method has failed.", value, checkDB.getPoints());
        System.out.println("Finished testAwardPoints");

    }

    @After
    public void tearDown() {
        this.tempDB.delete();
    }
}

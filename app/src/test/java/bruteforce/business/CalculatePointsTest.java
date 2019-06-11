package bruteforce.business;
import bruteforce.objects.Account;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;




public class CalculatePointsTest {

    /**
     Class: test_CalculatePoints
     Author: Ahmed Kidwai
     Purpose: This function tests to see if the CalculatePoints object in the business layer is functional.
     */

    @Test
    public void testConstructor(){

        System.out.println("Testing the the Constructor for CalculatePoints");

        AccessTask currUser = new AccessTask("username1");

        // Create AccessAcount object..
        AccessAccount currAccount = new AccessAccount("username1");

        currAccount.updatePoints(50);

        CalculatePoints testConstructor0;

        testConstructor0 = new CalculatePoints(currAccount, currUser, "username1");

        currUser.getTask(1);


        assertNotNull("The constructor has failed to initialize", testConstructor0);
        System.out.println("The constructor in the CalculatePoints class has run succesfully.");

    }


    /**
     Class: test_CalculatePoints
     Author: Ahmed Kidwai
     Purpose: This function tests to see if the AwardPoints method in the CalculatePoints
     //       object updates the users points based on the priority level, upon completion of a task.
     */

    @Test
    public void test_awardPoints() {

        System.out.println("Testing the Award Points Method in CalculatePoints");
        // Create AccessAcount object..
        AccessAccount currAccount = new AccessAccount("username1");

        //Create AccessTask object
        AccessTask currUser = new AccessTask("username1");
        currUser.getTask(1);
        currAccount.updatePoints(50);

        // Creates a CalculatePoints object.
        CalculatePoints testConstructor1 = new CalculatePoints(currAccount, currUser, "username1");

        // get the value of points rewarded.
        int value = testConstructor1.awardPoints();

        // Get the current user from the database
        Account checkDB = currAccount.getCurrentAccount();

        //check to see if current user information has updated correctly to the DB.
        assertEquals("The awardPoints method has failed", value, checkDB.getPoints());
        System.out.println("The awardPoints method has run successfully.");
    }
}
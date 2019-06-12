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
    public void ConstructorTest() {

        System.out.println("Testing Constructor For Calculate Points.");


        AccessTask currUser = new AccessTask("username1");

        // Create AccessAcount object..
        AccessAccount currAccount = new AccessAccount("username1");

        currAccount.updatePoints(50);

        CalculatePoints testConstructor0;

        testConstructor0 = new CalculatePoints(currAccount, currUser, "username1");

        currUser.getTask(1);


        assertNotNull("The award points constructor has failed to initialize.", testConstructor0);

        System.out.println("Constructor for Calculate Points has run successfully.");

    }


    /**
     Class: test_CalculatePoints
     Author: Ahmed Kidwai
     Purpose: This function tests to see if the AwardPoints method in the CalculatePoints
     //       object updates the users points based on the priority level, upon completion of a task.
     */

    @Test
    public void awardPointsTest() {

        System.out.println("Testing awardPoints method in  CalculatePoints Class.");

        // Create AccessAccount object.
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
        assertEquals("The awardPoints method has failed.", value, checkDB.getPoints());
        System.out.println("The awardPoints method has run successfully ");

    }

}
package bruteforce.objects;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 Class: AccountTest
 Author: Triet Nguyen
 Purpose: This class represents a single user account. the account has an ArrayList of Tasks and a plant object,
 as well as a username and password.
 */

public class AccountTest {

    /**
    testAccountFirstConstructor

    Purpose: test first constructor of Account class, this class has no parameter
    Parameters: none
    Returns: none, must print out finished to pass the test
    */
    @Test
    public void testAccountFirstConstructor() {
        Account user = new Account();
        System.out.println("\nStarting testAccountFirstConstructor");

        assertNotNull("Account object should not be null", user);
        assertEquals("getUserName() in account class is not correct", "username", user.getUsername());
        assertEquals("getPassword() in account class is not correct", "password", user.getPassword());

        System.out.println("Finished testAccountFirstConstructor");

    }

    /**
    testAccountSecondConstructor

    Purpose: test second constructor of Account class, this class has two parameters
    Parameters: none
    Returns: none, must print out finished to pass the test
    */
    @Test
    public void testAccountSecondConstructor() {
        Account user = new Account("John", "john987");
        System.out.println("\nStarting testAccountSecondConstructor");

        assertNotNull("Account object should not be null", user);
        assertEquals("getUserName() in account class is not correct", "John", user.getUsername());
        assertEquals("getPassword() in account class is not correct", "john987", user.getPassword());

        System.out.println("Finished testAccountSecondConstructor");
    }

    /**
    testAccountThirdConstructor

    Purpose: test third constructor of Account class, this class has three parameters
    Parameters: none
    Returns: none, must print out finished to pass the test
    */
    @Test
    public void testAccountThirdConstructor() {
        System.out.println("\nStarting testAccountThirdConstructor");

        Account user = new Account("John", "john987", 25, 0, 0);
        assertNotNull("Account object should not be null", user);
        assertEquals("getUserName() in account class is not correct", "John", user.getUsername());
        assertEquals("getPassword() in account class is not correct", "john987", user.getPassword());
        assertEquals("getPoints() in account class is not correct", 25, user.getPoints());

        System.out.println("Finished testAccountThirdConstructor");
    }
}
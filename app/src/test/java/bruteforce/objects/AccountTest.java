package bruteforce.objects;

import org.junit.Test;

import bruteforce.objects.Account;
import bruteforce.objects.Task;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 Class: AccountTest
 Author: Triet Nguyen
 Purpose: This class represents a single user account. the account has an ArrayList of Tasks and a plant object,
 as well as a username and password.
 */

public class AccountTest {
    private List<Task> list;

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

        assertNotNull("account object should not be null",user);
        assertEquals("getUserName() in account classs is not correct","username",user.getUsername());
        assertEquals("getPassword() in account class is not correct","password",user.getPassword());

        System.out.println("\nFinished testAccountFirstConstructor");

    }

    /**
     testAccountSecondConstructor

     Purpose: test second constructor of Account class, this class has two parameters
     Parameters: none
     Returns: none, must print out finished to pass the test
     */

    @Test
    public void testAccountSecondConstructor() {
        Account user = new Account("John","john987");
        System.out.println("\nStarting testAccountSecondConstructor");

        assertNotNull("account object should not be null",user);
        assertEquals("getUserName() in account classs is not correct","John",user.getUsername());
        assertEquals("getPassword() in account class is not correct","john987",user.getPassword());

        System.out.println("\nFinished testAccountSecondConstructor");
    }

    /**
     testAccountThirdConstructor

     Purpose: test third constructor of Account class, this class has three parameters
     Parameters: none
     Returns: none, must print out finished to pass the test
     */

    @Test
    public void testList() {
        System.out.println("\nStarting testAccountThirdConstructor");

        list = new ArrayList<>();
        Task firstTask = new Task("John");
        list.add(firstTask);
        Task secondTask;
        Date date;
        date = new Date(2019,8,20);
        secondTask = new Task("John",date,true);
        list.add(secondTask);

        Account user = new Account("John","john987", (ArrayList<Task>) list);
        assertNotNull("list which contains tasks should not be null",user.getUserTaskList());

        System.out.println("Finished testAccountThirdConstructor");
    }
}

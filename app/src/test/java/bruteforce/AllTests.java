package bruteforce;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import bruteforce.objects.Account;
import bruteforce.objects.Plant;
import bruteforce.objects.Task;

import bruteforce.objects.AccountTest;
import bruteforce.objects.PlantTest;
import bruteforce.objects.TaskTest;
import bruteforce.objects.AccessAccountTest;
import bruteforce.objects.AccessTaskTest;

/**
 Class: AllTests
 Author: Triet Nguyen
 Purpose: This class executes all object test class automatically.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccountTest.class,
        PlantTest.class,
        TaskTest.class,
        AccessAccountTest.class,
        //AccessTaskTest.class
})



public class AllTests {
}


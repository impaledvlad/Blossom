package bruteforce;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import bruteforce.objects.AccountTest;
import bruteforce.business.CalculatePointsTest;
import bruteforce.objects.PlantTest;
import bruteforce.objects.TaskTest;
import bruteforce.business.AccessAccountTest;

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
        CalculatePointsTest.class
})


public class AllTests {

}


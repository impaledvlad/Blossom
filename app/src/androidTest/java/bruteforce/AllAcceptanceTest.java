package bruteforce;

import android.support.test.filters.LargeTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 Class: AllAcceptanceTest
 Author: Triet Nguyen
 Purpose: This class executes all system test class automatically.
 */

@LargeTest
@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccountManagementTest.class,
        TaskManagementTest.class,
        PointsSystemTest.class,
        StatisticsTest.class
})

public class AllAcceptanceTest {
}

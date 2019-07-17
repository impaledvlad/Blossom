package bruteforce;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import bruteforce.business.AccessAccountIT;
import bruteforce.business.AccessTaskIT;
import bruteforce.business.CalculatePointsIT;

/**
 Class: AllIntegrationTests
 Author: Yunpeng Zhong
 Purpose: This class executes all itegration test class automatically.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessAccountIT.class,
        AccessTaskIT.class,
        CalculatePointsIT.class
})
public class AllIntegrationTests {
}

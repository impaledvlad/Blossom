package bruteforce.business;

import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.Test;


public class AccessTaskTest {

    @Test
    public void testGetTaskList() {
        AccessTask failTask = new AccessTask();
        AccessTask testTask = new AccessTask("username1");
        System.out.println("Starting testGetTaskList");

        assertEquals("This function should return null",null,failTask.getTaskList());
        assertNotEquals("This function should not be null",null,testTask.getTaskList());

        System.out.println("Finished testGetTaskList");
    }
}

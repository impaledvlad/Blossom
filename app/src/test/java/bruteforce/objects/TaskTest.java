package bruteforce.objects;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;

/**
 Class: TaskTest
 Author: Triet Nguyen
 Purpose: This class tests Task object constructor and its accessor method
 */

public class TaskTest {

    /**
    testTaskFirstConstructor

    Purpose: test first constructor of Task class, this constructor has one parameter
    Parameters: none
    Returns: none, must print out finished to pass the test
    */
    @Test
    public void testTaskFirstConstructor() {
        Task task = new Task();
        System.out.print("\nStarting testTaskFirstConstructor");

        assertNotNull("Task object should not be null", task);
        assertEquals("Task name should be blank", "", task.getName());
        assertEquals("Account name should be blank", "", task.getUsername());
        assertEquals("Task should not be completed", false, task.getCompleted());
        assertEquals("Task priority has been set yet", -1, task.getPriority());

        System.out.println("\nFinished testTaskFirstConstructor");

    }

    /**
    testTaskSecondConstructor

    Purpose: test second constructor of Task class, this constructor has one parameter
    Parameters: none
    Returns: none, must print out finished to pass the test
    */
    @Test
    public void testTaskSecondConstructor() {
        Task task;
        System.out.print("\nStarting testTaskSecondConstructor");

        task = new Task("Do exercise");
        assertNotNull("Task object should not be null", task);
        assertEquals("Task name is not correct", "Do exercise", task.getName());
        assertEquals("User name should be blank", "", task.getUsername());
        assertEquals("Task should not be completed", false, task.getCompleted());
        assertEquals("Task priority has been set yet", -1, task.getPriority());

        System.out.println("\nFinished testTaskSecondConstructor");
    }

    /**
    testTaskThirdConstructor

    Purpose: test third constructor of Task class, this class has two parameters
    Parameters: none
    Returns: none, must print out finished to pass the test
    */
    @Test
    public void testTaskThirdConstructor() {
        Task task;
        Date date;
        System.out.println("\nStarting testTaskThirdConstructor");

        date = new Date(2019, 8, 20);
        task = new Task("Go out for lunch", date);

        assertNotNull("Task object should not be null", task);
        assertEquals("Task name is not correct", "Go out for lunch", task.getName());
        assertEquals("Account name should be blank ", "", task.getUsername());
        assertEquals("Task should not be completed", false, task.getCompleted());
        assertEquals("Task priority has been set yet", -1, task.getPriority());
        assertEquals("Year is not valid", 2019, task.getDeadline().getYear());
        assertEquals("Month is not valid", 8, task.getDeadline().getMonth());
        assertEquals("Date is not valid", 20, task.getDeadline().getDate());

        System.out.println("Finished testTaskThirdConstructor");
    }

    /**
    testTaskFourthConstructor

    Purpose: test fourth constructor of Task class, this class has three parameters
    Parameters: none
    Returns: none, must print out finished to pass the test
    */
    @Test
    public void testTaskFourthConstructor() {
        Task task;
        Date date;
        boolean test = true;
        System.out.println("\nStarting testTaskFourthConstructor");

        date = new Date(2019, 8, 20);
        task = new Task("Vacation time", "John", date, true,9, 3);

        assertNotNull("Task object should not be null", task);
        assertEquals("Task name is not correct", "Vacation time", task.getName());
        assertEquals("Account name is not correct", "John", task.getUsername());
        assertEquals("Year is not valid", 2019, task.getDeadline().getYear());
        assertEquals("Month is not valid", 8, task.getDeadline().getMonth());
        assertEquals("Date is not valid", 20, task.getDeadline().getDate());
        assertEquals("Completion has problems", true, task.getCompleted());
        assertEquals("Task priority is not correct", 3, task.getPriority());

        System.out.println("Finished testTaskFourthConstructor");
    }
}
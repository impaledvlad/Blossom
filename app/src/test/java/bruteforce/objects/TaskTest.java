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

        assertNotNull("object should not be null", task);
        assertEquals("task name should be blank", "", task.getName());
        assertEquals("account name should be blank", "", task.getUsername());
        assertEquals("task should not be completed", false, task.getCompleted());
        assertEquals("task priority has been set yet", -1, task.getPriority());

        System.out.println("\nFinished testTaskSecondConstructor");

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
        System.out.print("\nStarting testTaskSecondConstuctor");

        task = new Task("Do exercise");
        assertNotNull("object should not be null", task);
        assertEquals("task name is not correct", "Do exercise", task.getName());
        assertEquals("user name should be blank", "", task.getUsername());
        assertEquals("task should not be completed", false, task.getCompleted());
        assertEquals("task priority has been set yet", -1, task.getPriority());

        System.out.println("\nFinished testTaskThirdConstructor");
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
        System.out.println("\nStarting testTaskSecondConstructor");

        date = new Date(2019, 8, 20);
        task = new Task("Go out for lunch", date);

        assertNotNull("object should not be null", task);
        assertEquals("task name is not correct", "Go out for lunch", task.getName());
        assertEquals("account name should be blank ", "", task.getUsername());
        assertEquals("task should not be completed", false, task.getCompleted());
        assertEquals("task priority has been set yet", -1, task.getPriority());
        assertEquals("year is not valid", 2019, task.getDeadline().getYear());
        assertEquals("month is not valid", 8, task.getDeadline().getMonth());
        assertEquals("date is not valid", 20, task.getDeadline().getDate());

        System.out.println("\nFinished testTaskSecondCosntructor");
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
        task = new Task("Vacation time", "John", date, true, 3);

        assertNotNull("object should not be null", task);
        assertEquals("task name is not correct", "Vacation time", task.getName());
        assertEquals("account name is not correct", "John", task.getUsername());
        assertEquals("year is not valid", 2019, task.getDeadline().getYear());
        assertEquals("month is not valid", 8, task.getDeadline().getMonth());
        assertEquals("date is not valid", 20, task.getDeadline().getDate());
        assertEquals("completion has problems", true, task.getCompleted());
        assertEquals("task priority is not correct", 3, task.getPriority());

        System.out.println("\nFinished testTaskFourthConstuctor");
    }
}

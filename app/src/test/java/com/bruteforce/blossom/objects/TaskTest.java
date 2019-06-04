package com.bruteforce.blossom.objects;

import org.junit.Test;

import bruteforce.objects.Task;
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
        Task task;
        System.out.print("\nStarting testTaskFirstConstuctor");

        task = new Task("John");
        assertNotNull("object should not be null",task);
        assertEquals("account name is not correct","John",task.getName());
        System.out.println("\nFinished testTaskFirstConstructor");
    }

    /**
     testTaskSecondConstructor

     Purpose: test second constructor of Task class, this class has two parameters
     Parameters: none
     Returns: none, must print out finished to pass the test
     */

    @Test
    public void testTaskSecondConstructor() {
        Task task;
        Date date;
        System.out.println("\nStarting testTaskSecondConstructor");

        date = new Date(2019,8,20);
        task = new Task("John",date);

        assertNotNull("object should not be null",task);
        assertEquals("account name is not correct","John",task.getName());
        assertEquals("year is not valid",2019,task.getDeadline().getYear());
        assertEquals("month is not valid",8,task.getDeadline().getMonth());
        assertEquals("date is not valid",20,task.getDeadline().getDate());

        System.out.println("\nFinished testTaskSecondCosntructor");
    }

    /**
     testTaskThirdConstructor

     Purpose: test third constructor of Task class, this class has three parameters
     Parameters: none
     Returns: none, must print out finished to pass the test
     */

    @Test
    public void testTaskThirdConstructor() {
        Task task;
        Date date;
        boolean test = true;
        System.out.println("\nStarting testTaskThirdConstructor");

        date = new Date(2019,8,20);
        task = new Task("John",date,true);

        assertNotNull("object should not be null",task);
        assertEquals("account name is not correct","John",task.getName());
        assertEquals("year is not valid",2019,task.getDeadline().getYear());
        assertEquals("month is not valid",8,task.getDeadline().getMonth());
        assertEquals("date is not valid",20,task.getDeadline().getDate());
        assertEquals("completion has problems",test,task.getCompleted());

        System.out.println("\nFinished testTaskThirdConstuctor");
    }
}

package bruteforce.objects;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import bruteforce.business.AccessTask;

/**
 Class: AccessTaskTest
 Author: Yunpeng Zhong
 Purpose: Test the AccessTask class
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccessTaskTest {


    /**
     * testGetTaskList
     * <p>
     * Purpose: test getTaskList method in the AccessTask Class
     * Parameters: none
     * Returns: none, must print out finished to pass the test
     */
    @Test
    public void testGetTaskList() {
        AccessTask accessTask = new AccessTask("username1");
        AccessTask accessTask1 = new AccessTask();

        System.out.println("\nStarting testGetTaskList");

        assertNull("When the Account not in the database it should return null", accessTask1.getTaskList());
        assertNotNull("When the account in the database, it should be not null",accessTask.getTaskList());

        System.out.println("Finished testGetTaskList");




    }

    /**
     * testGetTask
     * <p>
     * Purpose: test getTask method in the AccessTask Class
     * Parameters: none
     * Returns: none, must print out finished to pass the test
     */
    @Test
    public void testGetTask() {
        AccessTask accessTask = new AccessTask("username1");

        System.out.println("\nStarting testGetTask");

        assertNull("When the id not in the database, it should get null",accessTask.getTask(2));
        assertEquals("When get the task1 form database, it should get the task with name task2","Task2",accessTask.getTask(1).getName());

        System.out.println("Finished testGetTask");

    }

    /**
     * testInsertTask
     * <p>
     * Purpose: test getTask method in the AccessTask Class
     * Parameters: none
     * Returns: none, must print out finished to pass the test
     */
    @Test
    public void testInsertTask() {
        AccessTask accessTask = new AccessTask("username1");
        Task newTask = new Task("Task3", "username1", new Date(2019, 9, 20), false, 0);
        accessTask.insertTask(newTask);
        System.out.println("\nStarting testInsertTask");

        assertEquals("The new task should be equal to the task insert to database",newTask,accessTask.getTask(newTask.getTaskID()));

        System.out.println("Finished testInsertTask");
    }

    /**
     * testUpdateTask
     * <p>
     * Purpose: test updateTask method in the AccessTask Class
     * Parameters: none
     * Returns: none, must print out finished to pass the test
     */
    @Test
    public void testUpdateTask() {
        AccessTask accessTask = new AccessTask("username2");
        accessTask.getTask(2);

        System.out.println("\nStarting testUpdateTask");

        accessTask.updateComplete(false);
        accessTask.updateDeadline(new Date("2020/3/20"));
        accessTask.updateName("taskNameChange");
        accessTask.updatePriority(0);
        accessTask.updateTask();

        Task taskChange = accessTask.getTask(2);

        assertEquals("The new complete should be false",false,taskChange.getCompleted());
        assertEquals("The new deadline should be update",new Date("2020/3/20"),taskChange.getDeadline());
        assertEquals("The new Name should be taskNameChange","taskNameChange",taskChange.getName());
        assertEquals("The new priority should be 0",0,taskChange.getPriority());

        System.out.println("Finished testUpdateTask");
    }

    /**
     * testCompleteTask
     * <p>
     * Purpose: test complete method in the AccessTask Class
     * Parameters: none
     * Returns: none, must print out finished to pass the test
     */
    @Test
    public void testCompleteTask() {
        AccessTask accessTask = new AccessTask("username1");
        accessTask.getTask(0);

        System.out.println("\nStarting testCompleteTask");

        assertEquals("When complete the task it should return the priority with 1",1,accessTask.completeTask());

        System.out.println("Finished testCompleteTask");
    }

    /**
     * testDeleteTask
     * <p>
     * Purpose: test deleteTask method in the AccessTask Class
     * Parameters: none
     * Returns: none, must print out finished to pass the test
     */
    @Test
    public void testDeleteTask() {
        AccessTask accessTask = new AccessTask("username2");
        Task deleteTask = accessTask.getTask(3);
        System.out.println("\nStarting testDeleteTask");

        assertNotNull("the task going to delete not null",deleteTask);

        accessTask.deleteTask();

        assertNull("The task should be null after delete it",accessTask.getTask(3));

        System.out.println("Finished testDeleteTask");
    }

    /**
     * testRemoveAllTask
     * <p>
     * Purpose: test removeAllTask method in the AccessTask Class
     * Parameters: none
     * Returns: none, must print out finished to pass the test
     */
    @Test
    public void testRemoveAllTask() {
        AccessTask accessTask = new AccessTask("username3");

        System.out.println("\nStarting testRemoveAllTask");

        assertNotNull("Before remove all task the task list should not be null",accessTask.getTaskList());

        accessTask.removeAllTask();

        assertEquals("After remove all task the task list should have 0 element",0,accessTask.getTaskList().size());

        System.out.println("Finished testRemoveAllTask");
    }
}

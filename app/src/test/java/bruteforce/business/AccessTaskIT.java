package bruteforce.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;


import bruteforce.objects.Task;
import bruteforce.persistence.TaskPersistence;
import bruteforce.persistence.hsqldb.TaskPersistenceHSQLDB;
import bruteforce.utils.TestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class AccessTaskIT {
    private AccessTask accessTask;
    private File tempDB;


    @Before
    public void setUp() throws IOException {
        this.tempDB = TestUtils.copyDB();
        final TaskPersistence persistence = new TaskPersistenceHSQLDB(this.tempDB.getAbsolutePath().replace(".script", ""));
        this.accessTask = new AccessTask(persistence,"username1");
    }

    /**
     * testGetTaskList
     * <p>
     * Purpose: test getTaskList method in the AccessTask Class
     * Parameters: none
     * Returns: none, must print out finished to pass the test
     */
    @Test
    public void testGetTaskList() {

        System.out.println("\nStarting testGetTaskList");

        assertNotNull("When the Account not in the database it should return null", accessTask.getTaskList());

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
        accessTask.getTaskList();


        System.out.println("\nStarting testGetTask");

        assertNull("When the id not in the database, it should get null",accessTask.getTask(9));
        assertEquals("When get the task1 from database, it should get the task with name task2","Task2",accessTask.getTaskList().get(1).getName());

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
        Task newTask = new Task("Task3", "username1", new Date(2019, 9, 20),false,7,0);
        accessTask.insertTask(newTask);
        System.out.println("\nStarting testInsertTask");

        assertEquals("The new task should be equal to the task insert to database",newTask.getTaskID(),accessTask.getTask(newTask.getTaskID()).getTaskID());

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
        accessTask.getTask(accessTask.getTaskList().get(1).getTaskID());

        System.out.println("\nStarting testUpdateTask");

        accessTask.updateComplete(false);
        accessTask.updateDeadline(new Date("2020/3/20"));
        accessTask.updateName("taskNameChange");
        accessTask.updatePriority(0);
        accessTask.updateTask();

        Task taskChange = accessTask.getTaskList().get(1);

        assertEquals("The new complete should be false",false,taskChange.getCompleted());
        assertEquals("The new deadline should be updated",new Date("2020/3/20"),taskChange.getDeadline());
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
        int expected = accessTask.getTask(0).getPriority();
        System.out.println("\nStarting testCompleteTask");

        assertEquals("When complete the task it should return the proper priority every time",expected,accessTask.completeTask());

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

        Task deleteTask = accessTask.getTaskList().get(0);
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

        System.out.println("\nStarting testRemoveAllTask");

        assertNotNull("Before remove all task the task list should not be null",accessTask.getTaskList());

        accessTask.removeAllTask();

        assertEquals("After remove all task the task list should have 0 element",0,accessTask.getTaskList().size());

        System.out.println("Finished testRemoveAllTask");
    }
    @After
    public void tearDown() {
        this.tempDB.delete();
    }
}

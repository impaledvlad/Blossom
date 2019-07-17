package bruteforce.business;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bruteforce.objects.Task;

import bruteforce.persistence.TaskPersistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

/**
 Class: AccessAccountMockTest
 Author: Yunpeng Zhong
 Purpose: Add more mock test to cover all of AccessTask Class
 */
public class AccessTaskMockTest {
    private AccessTask accessTask;
    private TaskPersistence taskPersistence;

    @Before
    public void setUp(){
        taskPersistence = mock(TaskPersistence.class);
        accessTask = new AccessTask(taskPersistence);
    }
    /**
     * testIsExist
     * <p>
     * Purpose: test isExist method in the AccessTask Class
     * Parameters: none
     * Returns: none, must print out finished to pass the test
     */
    @Test
    public void testIsExist(){
        final List<Task> taskList = new ArrayList<>();
        taskList.add(new Task("Task1", "username1", new Date("2019/08/20"), false, 0,1));
        taskList.add(new Task("Task2", "username1", new Date("2019/7/20"), true, 1,2));
        System.out.println("\nStarting testIsExist");
        when(taskPersistence.getTasks("username1")).thenReturn(taskList);
        accessTask = new AccessTask(taskPersistence,"username1");
        assertFalse("If the task is not exist, should return false",accessTask.isExist(90));
        assertTrue("If the task is exist, should return false",accessTask.isExist(1));
        verify(taskPersistence,times(1)).getTasks("username1");
        System.out.println("Finished testIsExist");
    }
}

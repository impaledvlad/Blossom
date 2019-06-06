package bruteforce.persistence;

import java.util.List;
import bruteforce.objects.Task;
/**
 Interface: TaskPersistence
 Author: Sabit Rahman
 Purpose: An interface for the task database
 */
public interface TaskPersistence {

    /**
     insertTask

     Purpose: insert a new task to our task list
     Parameters: Task currentTask
     Returns: None
     */
    void insertTask(Task currentTask);

    /**
     updateTask

     Purpose: update a task in our task list
     Parameters: Task currentTask
     Returns: boolean true if success, false if not
     */
    boolean updateTask(Task currentTask);

    /**
     deleteTask

     Purpose: delete a task in our task list
     Parameters: Task currentTask
     Returns: boolean true if success, false if not
     */
    boolean deleteTask(Task currentTask);

    /**
     getTasks

     Purpose: get a list of task from that user
     Parameters: String accountName
     Returns: List<Task>
     */
    List<Task> getTasks(String userName);

}
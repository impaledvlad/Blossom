package bruteforce.persistence;

import bruteforce.objects.Task;
/**
 Interface: TaskPersistence
 Author: Sabit Rahman
 Purpose: An interface for the task database
 */
public interface TaskPersistence {

    Task insertTask(Task currentTask);

    Task updateTask(Task currentTask);

    void deleteTask(Task currentTask);
}
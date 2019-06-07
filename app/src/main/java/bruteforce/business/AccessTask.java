package bruteforce.business;
import java.util.Date;
import java.util.List;

import bruteforce.objects.Task;
import bruteforce.persistence.TaskPersistence;
import bruteforce.application.Services;
/**
Class: AccessTask
Author:  Yunpeng Zhong
Purpose: Business layer logic for a user Task
*/

public class AccessTask {

    private List<Task> tasks;
    private TaskPersistence taskPersistence;
    private Task currentTask;

    public AccessTask() {
        taskPersistence = Services.getTaskPersistence();
        tasks = null;
        currentTask = null;
    }

    public AccessTask(String userName) {
        taskPersistence = Services.getTaskPersistence();
        tasks = taskPersistence.getTasks(userName);
        currentTask = null;
    }

    /**
    getTask

    Purpose: get a specific task base on accountName and taskID
    Parameters: String accountName, taskID
    Returns: void
    */
    public void getTask(int taskId) {
        if(tasks != null) {
            Task task;
            for(int current = 0; current < tasks.size(); current++) {
                task = tasks.get(current);
                if(task.getTaskID()==taskId)
                {
                    currentTask = task;
                }
            }
        }
    }

    /**
    insertTask

    Purpose: insert a new Task into task list
    Parameters: Task task
    Returns: void
    */
    public void insertTask(Task task){
        taskPersistence.insertTask(task);
        tasksRenew(task.getName());
        tasks.add(task);
    }

    /**
    updateTask

    Purpose: update task into database
    Parameters: Task task
    Returns: void
    */
    public void updateTask(){
        if(currentTask!=null) {
            taskPersistence.updateTask(currentTask);
            tasksRenew(currentTask.getName());
            currentTask = null;
        }
    }

    /**
    deleteTask

    Purpose: delete task from the task list
    Parameters: Task task
    Returns: void
    */
    public void deleteTask(){
        if(currentTask!=null) {
            taskPersistence.deleteTask(currentTask);
            tasksRenew(currentTask.getName());
            currentTask = null;
        }
    }

    /**
    updateName

    Purpose: update the new name for task
    Parameters: String newName
    Returns: void
    */
    public void updateName(String newName) {
        if(currentTask!=null) {
            currentTask.setName(newName);
        }
    }

    /**
    updateDeadline

    Purpose: update the new Deadline for task
    Parameters: Date newDate
    Returns: void
    */
    public void updateDeadline(Date newDate) {
        if(currentTask!=null) {
            currentTask.setDeadline(newDate);
        }
    }

    /**
    updateComplete

    Purpose: update the new complete for task
    Parameters: boolean newComplete
    Returns: void
    */
    public void updateComplete(boolean newComplete) {
        if(currentTask!=null) {
            currentTask.setCompleted(newComplete);
        }
    }

    /**
    updatePriority

    Purpose: update the new priority for task
    Parameters: boolean newComplete
    Returns: void
    */
    public void updatePriority(int newPriority) {
        if(currentTask!=null) {
            currentTask.setPriority(newPriority);
        }
    }

    /**
    completeTask

    Purpose: when complete a task, set that task to be complete and return the priority for that to calculate the points
    Parameters: none
    Returns: int
    */
    public int completeTask() {
        if(currentTask!=null) {
            currentTask.setCompleted(true);
            taskPersistence.updateTask(currentTask);

            return currentTask.getPriority();
        }
        return -1;
    }

    /**
    removeAllTask

    Purpose: when delete user account also delete all user tasks for that user
    Parameters: none
    Returns: none
    */
    public void removeAllTask(){
        if(tasks.size()>0) {
            currentTask = tasks.get(0);
            deleteTask();
        }
    }

    /**
    tasksRenew

    Purpose: renew the current task list for that user
    Parameters: String userName
    Returns: None
    */
    private void tasksRenew(String userName) {
        tasks = taskPersistence.getTasks(userName);
    }
}
package bruteforce.business;
import java.util.Date;

import bruteforce.objects.*;
/**
Class: AccessTask
Author: Your name
Purpose: Business layer logic for a user Task
*/

public class AccessTask {
    //fields
    private Task currentTask;
    //constructors
    public AccessTask()
    {
        currentTask = null;
    }
    public AccessTask(Task currentTask){
        this.currentTask = currentTask;
    }
    //methods
    /**
     updateName

     Purpose: update the new name for task
     Parameters: String newName
     Returns: void
     */
    public void updateName(String newName)
    {
        currentTask.setName(newName);
    }
    /**
     updateDeadline

     Purpose: update the new Deadline for task
     Parameters: Date newDate
     Returns: void
     */
    public void updateDeadline(Date newDate)
    {
        currentTask.setDeadline(newDate);
    }
    /**
     updateComplete

     Purpose: update the new complete for task
     Parameters: boolean newComplete
     Returns: void
     */
    public void updateComplete(boolean newComplete)
    {
        currentTask.setCompleted(newComplete);
    }
    /**
     updatePriority

     Purpose: update the new priority for task
     Parameters: boolean newComplete
     Returns: void
     */
    public void updatePriority(int newPriority)
    {
        currentTask.setPriority(newPriority);
    }

    /**
     completeTask

     Purpose: when complete a task, set that task to be complete and return the priority for that to calculate the points
     Parameters: none
     Returns: int
     */
    public int completeTask() {
        currentTask.setCompleted(true);
        return currentTask.getPriority();
    }
}
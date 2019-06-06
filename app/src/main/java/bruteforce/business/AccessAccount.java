package bruteforce.business;
import java.util.Date;

import bruteforce.objects.Account;
import bruteforce.objects.Task;
import bruteforce.persistence.AccountPersistence;
import bruteforce.application.Services;

/**
Class: AccessAccount
Author: John Manning
Purpose: Business layer logic for a user account.
*/

public class AccessAccount {
    //fields
    private Account currentAccount;
    private AccountPersistence accountPersistence;
    //constructors
    public AccessAccount(Account currentAccount){
        accountPersistence = Services.getAccountPersistence();
        this.currentAccount = currentAccount;
    }
    //methods

    /**
     addTask

     Purpose: adds a task to the users task list
     Parameters: String name, Date deadline
     Returns: void
     */

    public void addTask(String name, Date deadline){
        Task newTask = new Task(name,deadline);
      //  currentAccount.getUserTaskList().add(newTask);
    }
    /**
     removeTask

     Purpose: deletes a task from the users task list.
     Parameters: int taskID
     Returns: the deleted task
     */
    public Task deleteTask(int taskID){
       int index = findTask(taskID);
       return currentAccount.getUserTaskList().remove(index);

    }
     /**
     findTask

     Purpose: returns the index of a task (in the arraylist)
     Parameters: int taskID = the unique taskId you want to get the index of
     Returns: integer i = index of the passed taskID
     */
    public int findTask(int taskID){
        boolean found = false;
        //i = index of task. 
        int i = 0; 
        //loop until found is true
        while(!found){
            //if the task at index i matches the taskID, set found to true.
        if(currentAccount.getUserTaskList().get(i).getTaskID() == taskID){
            found = true;
        }else{
            i++;
        }

        }
        return i;
    }
    public void updateUsername(String newUsername){
        currentAccount.setUsername(newUsername);
    }
    public void updatePassword(String newPassword){
        currentAccount.setPassword(newPassword);

    }
    /**
     updateTask

     Purpose: returns an accessTask object sepcific to the task you ask for 
     Parameters: int taskID = the unique taskId for the task you want access to
     Returns: An Accessed Task object.
     */
//    public void updateTask(int taskID){
//    AccessTask currentTask = new AccessTask(currentAccount.getUserTaskList().get(findTask(taskID)));
//    return currentTask;
//    }

    
    
}
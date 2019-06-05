package bruteforce.business;
import java.util.Date;

import bruteforce.objects.*;

/** 
Class: AccessAccount
Author: Your name
Purpose: Business layer logic for a user account.
*/

public class AccessAccount {
    //fields
    private Account currentAccount;
    //constructors
    public AccessAccount(Account currentAccount){
            this.currentAccount = currentAccount;
    }
    /**
     addTask

     Purpose: returns the users plant object.
     Parameters: String name, Date deadline
     Returns: void
     */

    public void addTask(String name, Date deadline){
        Task newTask = new Task(name,deadline);
        currentAccount.getUserTaskList().add(newTask);
    }

    //methods
    
}
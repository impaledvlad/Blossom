package bruteforce.business;
import java.util.Date;

import bruteforce.objects.Account;
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
    public AccessAccount(){
        accountPersistence = Services.getAccountPersistence();
        this.currentAccount = null;
    }
    public AccessAccount(String userName){
        accountPersistence = Services.getAccountPersistence();
        currentAccount = accountPersistence.getAccount(userName);
    }
    //methods


    /**
     getAccount

     Purpose: set a specific account base on username to current account
     Parameters: String accountName
     Returns: void
     */
    public void getAccount(String userName) {
        currentAccount = accountPersistence.getAccount(userName);
    }

    /**
     insertAccount

     Purpose: insert an account to our database
     Parameters: Task task
     Returns: void
     */
    public void insertAccount(Account account){
        accountPersistence.insertAccount(account);
    }

    /**
     updateAccount

     Purpose: update an account into database
     Parameters: None
     Returns: void
     */
    public void updateAccount(){
        if(currentAccount!=null) {
            accountPersistence.updateAccount(currentAccount);
        }
    }

    /**
     deleteAccount

     Purpose: delete task from the database
     Parameters: None
     Returns: void
     */
    public void deleteAccount(){
        if(currentAccount!=null) {
            accountPersistence.deleteAccount(currentAccount);
        }
    }

    /**
     updatePoints

     Purpose: update the point for the current user(make sure user can't change it)
     Parameters: int newPoints
     Returns: void
     */
    public void updatePoints(int newPoints){
        currentAccount.setPoints(newPoints);
        updateAccount();
    }

    /**
     updatePassword

     Purpose: update the passWord for the current user
     Parameters: String newPassword
     Returns: void
     */
    public void updatePassword(String newPassword){
        currentAccount.setPassword(newPassword);
    }
}
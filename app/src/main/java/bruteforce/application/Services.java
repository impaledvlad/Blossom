package bruteforce.application;
import bruteforce.application.Exceptions.ApplicationExceptions;
import bruteforce.business.AccessAccount;
import bruteforce.business.Exceptions.NotLoginException;
import bruteforce.objects.Account;
import bruteforce.persistence.AccountPersistence;
import bruteforce.persistence.TaskPersistence;
import bruteforce.persistence.stubs.AccountPersistenceStub;
import bruteforce.persistence.stubs.TaskPersistenceStub;

/**
 Class: Services
 Author: Yunpeng Zhong
 Purpose: To set up all databases for the application
 */

public class Services{
    private static AccountPersistence accountPersistence = null;
    private static TaskPersistence taskPersistence = null;
    private static Account account = null;
    /**
    getAccountPersistence

    Purpose: return a stub AccountPersistence if there are no data base created
    Parameters: none
    Returns: AccountPersistence
    */
    public static synchronized AccountPersistence getAccountPersistence() {
        if(accountPersistence == null) {
        	accountPersistence = new AccountPersistenceStub();
        }

        return accountPersistence;
    }
    
    /**
    getTaskPersistence

    Purpose: return a stub TaskPersistence if there are no data base created
    Parameters: none
    Returns: TaskPersistence
    */
    public static synchronized TaskPersistence getTaskPersistence() {
       if(taskPersistence == null) {
    	   taskPersistence = new TaskPersistenceStub();
       }

       return taskPersistence;
   }

    /**
     * getAccount

     Purpose: return account that currently log in
     Parameters: none
     Returns: Account
     */
     public static Account getAccount() {
        if (account == null) {
            throw new NotLoginException();
        }
        return account;
     }

    /**
     setAccount

     Purpose: set this account to log in state
     Parameters: Account newAccount
     Returns: none
     */
     public static void setAccount(Account newAccount) {
        if (newAccount == null) {
            throw new ApplicationExceptions(
                    "illegal access, setting global account to be null",
                    new NullPointerException("Services.account"));
        }
        account = newAccount;
     }

    /**
     reset

     Purpose: reset application status
     Parameters: none
     Returns: none
     */
     public static void reset() {
        account = null;
        accountPersistence = null;
        taskPersistence = null;
     }
}
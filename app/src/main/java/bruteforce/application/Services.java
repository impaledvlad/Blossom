package bruteforce.application;
import bruteforce.persistence.AccountPersistence;
import bruteforce.persistence.TaskPersistence;
import bruteforce.persistence.stubs.AccountPersistenceStub;
import bruteforce.persistence.stubs.TaskPersistenceStub;
import bruteforce.persistence.hsqldb.AccountPersistenceHSQLDB;
import bruteforce.persistence.hsqldb.TaskPersistenceHSQLDB;

/**
 Class: Services
 Author: Yunpeng Zhong
 Purpose: To set up all databases for the application
 */

public class Services{
    private static AccountPersistence accountPersistence = null;
    private static TaskPersistence taskPersistence = null;

    /**
    getAccountPersistence

    Purpose: return a stub AccountPersistence if there are no data base created
    Parameters: none
    Returns: AccountPersistence
    */
    public static synchronized AccountPersistence getAccountPersistence() {
        if(accountPersistence == null) {
        	//accountPersistence = new AccountPersistenceStub();
            accountPersistence = new AccountPersistenceHSQLDB(Main.getDBPathName());
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
    	   //taskPersistence = new TaskPersistenceStub();
           taskPersistence = new TaskPersistenceHSQLDB(Main.getDBPathName());

       }

       return taskPersistence;
   }
}
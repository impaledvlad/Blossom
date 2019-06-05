package bruteforce.application;
import bruteforce.persistence.AccountPersistence;
import bruteforce.persistence.stubs.*;
/**
 Class: Services
 Author: Yunpeng Zhong
 Purpose: To set up all data bases for the app
 */
public class Services{
    private static AccountPersistence accountPersistence = null;

    /**
     getAccountPersistence

     Purpose: return a stub AccountPersistence if there are no data base created
     Parameters: none
     Returns: AccountPersistence
     */
    public static synchronized AccountPersistence getAccountPersistence() {
        if(accountPersistence == null)
        {
            //accountPersistence = new AccountPersistenceStub();
        }

        return accountPersistence;
    }
}
package bruteforce.persistence;

import bruteforce.objects.Account;

/**
 Interface: AccountPersistence
 Author: Yunpeng Zhong
 Purpose: An interface for the account database
 */
public interface AccountPersistence {

    /**
    insertAccount

    Purpose: insert a new account to our account list
    Parameters: Account currentAccount
    Returns: void
    */
    void insertAccount(Account currentAccount);

    /**
    updateAccount

    Purpose: update an account in our account list
    Parameters: Account currentAccount
    Returns: boolean true if success, false if not
    */
    boolean updateAccount(Account currentAccount);

    /**
    deleteAccount

    Purpose: delete an account in our task list
    Parameters: Account currentAccount
    Returns: boolean true if success, false if not
    */
    boolean deleteAccount(Account currentAccount);

    /**
    getAccount

    Purpose: get an account with the given userName
    Parameters: String userName
    Returns: Account
    */
    Account getAccount(String userName);
}
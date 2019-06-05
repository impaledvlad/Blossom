package bruteforce.persistence;

import bruteforce.objects.Account;
/**
 Interface: AccountPersistence
 Author: Yunpeng Zhong
 Purpose: An interface for the account database
 */
public interface AccountPersistence {

    Account insertAccount(Account currentAccount);

    Account updateAccount(Account currentAccount);

    void deleteAccount(Account currentAccount);
}
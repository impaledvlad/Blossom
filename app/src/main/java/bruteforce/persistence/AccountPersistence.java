package bruteforce.persistence;

import bruteforce.objects.Account;

public interface AccountPersistence {

    Account insertAccount(Account currentAccount);

    Account updateAccount(Account currentAccount);

    void deleteAccount(Account currentAccount);
}
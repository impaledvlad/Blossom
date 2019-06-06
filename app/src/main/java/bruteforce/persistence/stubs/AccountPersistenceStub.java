package bruteforce.persistence.stubs;

import java.util.ArrayList;
import java.util.List;

import bruteforce.objects.Account;
import bruteforce.persistence.AccountPersistence;
public class AccountPersistenceStub implements AccountPersistence {
	
	private List<Account> accounts;
	
	public AccountPersistenceStub() {
		this.accounts = new ArrayList<>(); 
				
		accounts.add(new Account("username1", "password1", 0 ));
		accounts.add(new Account("username2", "password2", 1 ));
	}

    public void insertAccount(Account currentAccount){
	}

    public Account updateAccount(Account currentAccount){
    	return null;
	}

    public void deleteAccount(Account currentAccount){}
}
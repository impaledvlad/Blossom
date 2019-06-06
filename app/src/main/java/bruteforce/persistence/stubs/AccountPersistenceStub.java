package bruteforce.persistence.stubs;

import java.util.ArrayList;

public class AccountPersistenceStub implements AccountPersistence {
	
	private List<Account> accounts;
	
	public AccountPersistenceStub() {
		this.accounts = new ArrayList<>(); 
				
		accounts.add(new Account("username1", "password1", 0 ));
		accounts.add(new Account("username2", "password2", 1 ));
	}

    Account insertAccount(Account currentAccount);

    Account updateAccount(Account currentAccount);

    void deleteAccount(Account currentAccount);
}
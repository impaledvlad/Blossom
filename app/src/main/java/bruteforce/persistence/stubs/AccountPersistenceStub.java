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

	/**
	insertAccount

	Purpose: insert a new account to our account list
	Parameters: Account currentAccount
	Returns: None
	*/
	@Override
    public void insertAccount(Account currentAccount){
		accounts.add(currentAccount);
	}

	/**
	updateAccount

	Purpose: update an account in our account list
	Parameters: Account currentAccount
	Returns: boolean true if success, false if not
	*/
	@Override
    public boolean updateAccount(Account currentAccount){
//		Account account;
//		int index = -1;
//		for(int counter = 0; counter<accounts.size();counter++)
//		{
//			account = accounts.get(counter);
//			if(account.getUsername().equals(currentAccount.getUsername()))
//			{
//				index = accounts.indexOf(account);
//			}
//		}
		/**
		 If the test fail, use the code above
		 */
		int index = accounts.indexOf(currentAccount);
		if(index >=0 )
		{
			accounts.set(index,currentAccount);
			return true;
		}
		return false;
	}

	/**
	deleteAccount

	Purpose: delete an account in our task list
	Parameters: Account currentAccount
	Returns: boolean true if success, false if not
	*/
	@Override
    public boolean deleteAccount(Account currentAccount){
//		Account account;
//		int index = -1;
//		for(int counter = 0; counter<accounts.size();counter++)
//		{
//			account = accounts.get(counter);
//			if(account.getUsername().equals(currentAccount.getUsername()))
//			{
//				index = accounts.indexOf(account);
//			}
//		}
		/**
		 If the test fail, use the code above
		 */
		int index = accounts.indexOf(currentAccount);
		if(index >=0 )
		{
			accounts.remove(index);
			return true;
		}
		return false;
	}

	/**
	getAccount

	Purpose: get an account with the given userName
	Parameters: String userName
	Returns: boolean true if success, false if not
	*/
	@Override
    public Account getAccount(String userName){
		Account currentAccount = new Account();
		for(int counter = 0; counter<accounts.size();counter++)
		{
			currentAccount = accounts.get(counter);
			if(currentAccount.getUsername().equals(userName)){
				return currentAccount;
			}
		}
		return null;
	}
}
/*---------------------------------------
 Genuine author: Segev Nagar, I.D.: 312529316
 Date: 29-12-2018
---------------------------------------*/

/**
 * This class has access to 2 databases:
 * 1. Bank accounts ordered by their client names
 * 2. Bank accounts ordered by their clients account numbers
 *
 * It allows the user to execute numerous actions on those databases:
 * Get a client name by its account number and vice versa,  add & remove bank accounts, deposit and withdraw money, ETC
 *
 * @author Segev Nagar
 */

public class Bank {

	private BankAccountsBinarySearchTree namesTree;
	private BankAccountsBinarySearchTree accountNumbersTree;


	/**
	 * The constructor of the class, which initializes all of the class fields:
	 */
	public Bank() {
		namesTree = new BankAccountsBinarySearchTree(new AccountComparatorByName());
		accountNumbersTree = new BankAccountsBinarySearchTree(new AccountComparatorByNumber());
	}

	/** This method gets a name and returns its client's account number
	 *
	 * @param name The name of the account user
	 * @return the account number of that user, or NULL if it wasn't found
	 */
	public BankAccount lookUp(String name){
		// create an Entry with the given name, a "dummy" accountNumber (1) and zero balance
		// This "dummy" accountNumber will be ignored when executing getData
		BankAccount lookFor = new BankAccount(name, 1, 0);
		return (BankAccount)namesTree.findData(lookFor);
	}

	/** This method gets an accounts number and returns its client's number
	 *
	 * @param accountNumber The account number of the client
	 * @return the name of that client, or NULL if it wasn't found
	 */
	public BankAccount lookUp(int accountNumber){
		// create an Entry with a "dummy" name, zero balance and the given accountNumber
		// This "dummy" name will be ignored when executing getData
		BankAccount lookFor = new BankAccount("dummy", accountNumber,0);
		return (BankAccount)accountNumbersTree.findData(lookFor);
	}

	/** This method makes the accounts tree and names tree balanced.
	 * In balanced tree, the height difference between 2 sub trees of the same node will never exceed 1.
	 *
	 */
	public void balance(){
		namesTree.balance();
		accountNumbersTree.balance();
	}

	/**
	 * @return the current names tree.
	 */
	public Object exportNames() {
		return this.namesTree;
	}

	/**
	 * @return the current account numbers tree.
	 */
	public Object exportAccountNumbers() {
		return this.accountNumbersTree;
	}
	
	// END OF Given code -----------------------------------

	/** This method gets a bank accounts and adds it to both trees.
	 *
	 * @param newAccount The account to be added
	 * @return True if the account was successfully added to the trees,
	 * False if either the name or the account number of that Bank Account already existed in one of the trees.
	 */

	//Complete the following method
	public boolean add(BankAccount newAccount) {
		String name = newAccount.getName();
		int number = newAccount.getAccountNumber();

		// Checking if account name already exists
		if(lookUp(name) == null)
			return false;

		// Checking if account number already exists
		if(lookUp(number) == null)
			return false;

		// Inserting the account to both trees
		namesTree.insert(newAccount);
		accountNumbersTree.insert(newAccount);
		return true;

	}


	/** This method gets an account name, and removes its matched bank accounts from both trees
	 *
	 * @param name The name of the bank account to be deleted
	 * @return True if the bank accounts were successfully deleted from the trees,
	 * False if the name wasn't found in one of the trees
	 */

	//Complete the following method
	public boolean delete(String name){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(name);
		// complete this:
		if(toRemove == null)	// Verifying the account name exists in names tree, returns false if not
			return false;

		int numberToRemove = toRemove.getAccountNumber();
		if(lookUp(numberToRemove) == null)	// Verifying the account number exists in account numbers tree, returns false if not
			return false;

		// Removing the account from both trees:
		namesTree.remove(toRemove);
		accountNumbersTree.remove(toRemove);
		return true;
	}

	/** This method gets an account number, and removes its matched bank accounts from both trees
	 *
	 * @param accountNumber The name of the bank account to be deleted
	 * @return True if the bank accounts were successfully deleted from the trees,
	 * False if the account number wasn't found in one of the trees
	 */

	//Complete the following method
	public boolean delete(int accountNumber){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(accountNumber);
		// complete this:
		if(toRemove == null)	// Verifying the account number exists in account numbers tree, returns false if not
			return false;

		String nameToRemove = toRemove.getName();
		if(lookUp(nameToRemove) == null)	// Verifying the account name exists in names tree, returns false if not
			return false;

		// Removing the account from both trees:
		namesTree.remove(toRemove);
		accountNumbersTree.remove(toRemove);
		return true;
	}

	/** Gets an amount of money and adds it to the input account number balance
	 *
	 * @param amount The amount to be added
	 * @param accountNumber The account number to add the money to
	 * @return True if the amount was successfully transferred to the account,
	 * False if the amount wasn't legal (negative)
	 */

	//Complete the following method
	public boolean depositMoney(int amount, int accountNumber){
		BankAccount account = lookUp(accountNumber);
		if(account == null) // If the account number wasn't found in the system
			return false;

		return account.depositMoney(amount);
	}

	/** Gets an amount of money and withdraw it from the input account number balance
	 *
	 * @param amount The amount to be added
	 * @param accountNumber The account number to add the money to
	 * @return True if the amount was successfully withdrawn from the account,
	 * False if the amount wasn't legal (negative), or that it was bigger that the accounts balance
	 */

	//Complete the following method
	public boolean withdrawMoney(int amount, int accountNumber){
		BankAccount account = lookUp(accountNumber);
		if(account == null) // If the account number wasn't found in the system
			return false;

		return account.withdrawMoney(amount);
	}
	


}

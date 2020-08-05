/*---------------------------------------
 Genuine author: Segev Nagar, I.D.: 312529316
 Date: 29-12-2018
---------------------------------------*/
import java.util.Comparator;

public class AccountComparatorByName implements Comparator<BankAccount>{

	@Override
	//Complete the following method
	public int compare(BankAccount account1, BankAccount account2) {
		// Using String's library compare method - which returns negative, positive and 0 values based on lexicographic order
		return account1.getName().compareTo(account2.getName());
	}

}

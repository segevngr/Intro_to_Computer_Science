/*---------------------------------------
 Genuine author: Segev Nagar, I.D.: 312529316
 Date: 29-12-2018
---------------------------------------*/
import java.util.Comparator;

public class AccountComparatorByNumber implements Comparator<BankAccount>{

	@Override
	//Complete the following method
	public int compare(BankAccount account1, BankAccount account2) {
		if(account1.getBalance() > account2.getBalance())
		    return 1;
        if(account1.getBalance() < account2.getBalance())
            return -1;

		return 0;
	}

}

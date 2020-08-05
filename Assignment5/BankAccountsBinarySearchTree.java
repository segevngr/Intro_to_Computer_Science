/*---------------------------------------
 Genuine author: Segev Nagar, I.D.: 312529316
 Date: 29-12-2018
---------------------------------------*/
import java.util.Comparator;
import java.util.Iterator;

public class BankAccountsBinarySearchTree extends BinarySearchTree<BankAccount>{

	public BankAccountsBinarySearchTree(Comparator<BankAccount> myComparator) {
		super(myComparator);
	}
	
	//Complete the following method
	public void balance(){

	}
	
	//Complete the following method
	private void buildBalancedTree(BankAccountsBinarySearchTree tree, List<BankAccount> list, int low, int high){

	}

	public Iterator<BankAccount> iterator(){
		return new FilteredBankAccountsIterator(this);
	}
	
}

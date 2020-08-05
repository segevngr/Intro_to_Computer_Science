import java.util.Iterator;


public class FilteredBankAccountsIterator implements Iterator<BankAccount> {

    private BankAccountsBinarySearchTree bankAccountsTree;
    private BankAccount current;

    //Complete the following method
    public FilteredBankAccountsIterator(BankAccountsBinarySearchTree bankAccountsTree) {

    }

    //Complete the following method
    @Override
    public boolean hasNext() {
        return false;
    }

    //Complete the following method
    @Override
    public BankAccount next() {
        return null;
    }

    //Do not change this method.
    public void remove() {
        return;
    }
}

/*---------------------------------------
 Genuine author: Segev Nagar, I.D.: 312529316
 Date: 29-12-2018
---------------------------------------*/
public class TestPrimeIterator {

	public static void main(String[] args) {
		PrimeIterator iter = new PrimeIterator();
		for (int i = 1; i < 21; i = i + 1) {
			System.out.print(iter.next()+", ");
		}
	}

}

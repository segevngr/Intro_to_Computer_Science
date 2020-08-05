/*---------------------------------------
 Genuine author: Segev Nagar, I.D.: 312529316
 Date: 29-12-2018
---------------------------------------*/
import java.util.Comparator;

//This comparator is used for demonstrations in Test classes.
public class IntegerComparator implements Comparator<Integer>{

	public IntegerComparator() {
		super();
	}

	@Override
	public int compare(Integer number1, Integer number2) {

		return number1.compareTo(number2);
	}
}

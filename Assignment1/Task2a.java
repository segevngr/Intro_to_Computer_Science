import java.util.Scanner;

public class Task2a {

	public static void main(String[] args) {

		// ----------------- write your code BELOW this line only --------
		// your code here (add lines)

		Scanner in = new Scanner(System.in);
		int fact = 1;
		int n = in.nextInt();
		for (int i = 1; i <= n; i++) {
			fact = fact * i;
		}
		System.out.println(fact);

		// ----------------- write your code ABOVE this line only ---------
	}
}

import java.util.Scanner;

public class Task4c {

	public static void main(String[] args) {

		// ----------------- write your code BELOW this line only --------
		// your code here (add lines)

		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		int e = in.nextInt();
		int f = in.nextInt();
		double sum;

		sum = (double)a/b + (double)c/d + (double)e/f;

		if(sum == 1)
			System.out.println("Yes");
		else
			System.out.println("No");

		// ----------------- write your code ABOVE this line only ---------

	}
}

import java.util.Scanner;

public class Task4b {
	
	public static void main(String[] args) {

            // ----------------- write your code BELOW this line only --------
            // your code here (add lines)

		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int multiple = a*b*c;
		int min = multiple;

		/* The following loop goes through all of the numbers between 1 and the highest possible common-multiple (a*b*c),
		 and stores the minimum common-multiple inside 'min' */
		for(int i=multiple; i > 0; i--)
			if(i % a == 0 && i%b ==0 && i%c ==0)
				min = i;

		System.out.println(min);

		// ----------------- write your code ABOVE this line only ---------
		
	}
}

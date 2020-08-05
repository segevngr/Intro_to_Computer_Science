import java.util.Scanner;

public class Task3 {
	public static void main(String[] args) {

		// ----------------- write your code BELOW this line only --------
		// your code here (add lines)

		Scanner in = new Scanner(System.in);
		int counter = 0, temp;
		int num = in.nextInt();
		for (int i = 2; i <= num; i++) {
			if (num % i == 0)// Checks whether i is a divider of num
			{
				for (int j = 2; j <= i; j++) // Checks if i is a primal number
				{
					if (i % j == 0 && i != j)
						break; // i isn't a primal number: moving on to check i+1
					if(j == i) // i is primal: calculates number of appereances inside num and prints
					{
						temp = num;
						while(temp % i == 0) {
							counter++;
							temp = temp / i;
						}
						System.out.println(i +" " +counter);
						counter = 0;
					}
				}
			}
		}


	}
}
import java.util.Scanner;

public class Task1a {
	
	public static void main(String[] args)
    {
        // ----------------- write your code BELOW this line only --------
        // your code here (add lines)
	    Scanner in = new Scanner(System.in);
	    int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        if(a*a + b*b == c*c)
            System.out.println(" Yes ");
        else
            System.out.println(" No ");
        // ----------------- write your code ABOVE this line only ---------
	}
}

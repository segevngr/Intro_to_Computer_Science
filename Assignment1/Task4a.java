import java.util.Scanner;

public class Task4a {

    public static void main(String[] args) {

        // ----------------- write your code BELOW this line only --------
        // your code here (add lines)

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int div = 1, maxDiv = 1;
        while (div <= a && div <= b && div <= c) {
            if (a % div == 0 && b % div == 0 && c % div == 0)
                maxDiv = div;
            div++;
        }
        System.out.println(maxDiv);

        // ----------------- write your code ABOVE this line only ---------

    }
}

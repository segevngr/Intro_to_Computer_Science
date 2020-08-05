import java.util.Scanner;

public class Task1b {

    public static void main(String[] args) {

        // ----------------- write your code BELOW this line only --------
        // your code here (add lines)

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = 0;
        while (a < n) {
            for (int b = 0; b < n; b++)
                for (int c = 0; c < n; c++) {
                    if (a < b && b < c) {
                        if (a * a + b * b == c * c)
                            System.out.println(a + " " + b + " " + c);
                    }
                }
            a++;
        }

        // ----------------- write your code ABOVE this line only ---------
    }
}


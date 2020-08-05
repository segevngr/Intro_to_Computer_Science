// You may not change or erase any of the lines and comments 
// in this file. You may only add lines in the designated 
// area.

import java.util.Scanner;

public class Task5 {


    public static void main(String[] args){
 

            // ----------------- "A": write your code BELOW this line only --------
            // your code here (add lines)

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        int e = in.nextInt();
        int tmp, tmp1, tmp2;

        // The following conditions rearranges the variables in an increasing sequence so that a < b < c < d < e
        if (b>=a && b>=c)
        {
            if(a>c)
            {
                tmp = c;
                c = a;
                a = tmp;
            }
            tmp = c;
            c = b;
            b = tmp;

        }
        else
        {
            if (a>c)
            {
                tmp = a;
                a = c;
                c = tmp;
            }

            if(b<a)
            {
                tmp = a;
                a = b;
                b = tmp;
            }
        }

        if(c>d && c>e)
        {
            tmp = e;
            e = c;
            c = tmp;

            if(c>=d)
            {
                if(a>d)
                {
                    tmp1 = a;
                    a = d;
                    d = tmp1;
                }
            }
            else
            {
                if(a>c)
                {
                    tmp2 = a;
                    a = c;
                    c = tmp2;
                }
            }
        }
        else
        {
            if(d>e)
            {
                tmp = d;
                d = e;
                e = tmp;
            }
            if(a>d)
            {
                tmp = a;
                a = d;
                d = tmp;
            }
        }

        System.out.println(a + " " + e);

        // ----------------- "B" write your code ABOVE this line only ---------

    } // end of main
} //end of class Task5


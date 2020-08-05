// You may not change or erase any of the lines and comments 
// in this file. You may only add lines.

import java.util.Scanner;
public class Task6
{
    public static void main(String[] args)
    {
        // ----------------- write any code BELOW this line only --------
        // your code here (add lines)
        int a=0;
        int b=0;
        int c=0;
        int d=0;
        int e=0;

        /* The following loop indexes varies between 0 and 1, and assigns them to a, b, c, d, e
        Therefore all of the variable combinations should be checked */
        for(int i=0; i<2; i++)
        {
            for(int j=0; j<2; j++)
            {
                for(int k=0; k<2; k++)
                {
                    for(int l=0 ;l<2; l++)
                    {
                        d=l;
                        for(int m=0 ;m<2; m++)
                        {
                            // Assigns the loop indexes to the variables
                            a=i;
                            b=j;
                            c=k;
                            d=l;
                            e=m;

                            // ----------------- write any code ABOVE this line only ---------

                            // -----------------  copy here the code from Task 5 that is between
                            // -----------------  the comments "A" and "B"
                            // code from Task 5 here

                            // The following conditions rearranges the variables in an increasing sequence so that a < b < c < d < e
                            if (b>=a && b>=c)
                            {
                                if(a>c)
                                {
                                    int tmp = c;
                                    c = a;
                                    a = tmp;
                                }
                                int tmp = c;
                                c = b;
                                b = tmp;

                            }
                            else
                            {
                                if (a>c)
                                {
                                    int tmp = a;
                                    a = c;
                                    c = tmp;
                                }

                                if(b<a)
                                {
                                    int tmp = a;
                                    a = b;
                                    b = tmp;
                                }
                            }

                            if(c>d && c>e)
                            {
                                int tmp = e;
                                e = c;
                                c = tmp;

                                if(c>=d)
                                {
                                    if(a>d)
                                    {
                                        int tmp1 = a;
                                        a = d;
                                        d = tmp1;
                                    }
                                }
                                else
                                {
                                    if(a>c)
                                    {
                                        int tmp2 = a;
                                        a = c;
                                        c = tmp2;
                                    }
                                }
                            }
                            else
                            {
                                if(d>e)
                                {
                                    int tmp = d;
                                    d = e;
                                    e = tmp;
                                }
                                if(a>d)
                                {
                                    int tmp = a;
                                    a = d;
                                    d = tmp;
                                }
                            }

                            // -----------------  end of copied code from Task 5
                            // ----------------- write any code BELOW this line only --------
                            // your code here (add lines)


                            // Verifies the cases in which all of the variables are identical:
                            if((a==0 && b==0 && c==0 && d==0 && e==0)
                                    || (a==1 && b==1 && c==1 && d==1 && e==1))
                                System.out.println("verified");

                            else {
                                if(a!=0 || e!=1) // There's a mistake!
                                    System.out.println(a+" "+b+" "+c+" "+d+" "+e);
                                else
                                    System.out.println("verified");
                            }
                        }
                    }
                }
            }
        }
        // ----------------- write any code ABOVE this line only ---------
    } // end of main
} //end of class Task6


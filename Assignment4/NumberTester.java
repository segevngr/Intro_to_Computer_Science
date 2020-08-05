import java.util.Iterator;

public class NumberTester
{
    public static void main(String[] args)
    {
        System.out.println("testNumber() = " + testNumber());
        System.out.println("testIsZero() = " + testIsZero());
        System.out.println("testBitIterator() = " + testBitIterator());
        System.out.println("testIncrement() = " + testIncrement());
        System.out.println("testIsLegal() = " + testIsLegal());
        System.out.println("testEquals() = " + testEquals());
        System.out.println("testToString() = " + testToString());
        System.out.println("testLessEq() = " + testLessEq());
        System.out.println("testLessThan() = " + testLessThan());
        System.out.println("testCompareTo() = " + testCompareTo());
        System.out.println("testAdd() = " + testAdd());
        System.out.println("testMultiply() = " + testMultiply());
    }


    public static boolean testNumber(){
        Number num = new Number();
        Iterator<Bit> iter = num.bitIterator();

        // Empty Constructor test
        if(!(iter.hasNext()))
            return false;
        Bit bit = iter.next();
        if(!(bit.isZero()))
            return false;

        // Int Constructor test
        num = new Number(7);    // 11
        iter = num.bitIterator();
        while(iter.hasNext()){
            bit = iter.next();
            if(!(bit.isOne()))
                return false;
        }

        // String Constructor test
        num = new Number("127"); //1111111
        iter = num.bitIterator();
        while(iter.hasNext()){
            bit = iter.next();
            if(!(bit.isOne()))
                return false;
        }

        return true;
    }


    public static boolean testIsZero(){
        Number num = new Number();
        if(!(num.isZero()))
            return false;
        num = new Number(1);
        if(num.isZero())
            return false;
        num = new Number("0");
        if(!(num.isZero()))
            return false;

        return true;
    }

    public static boolean testBitIterator(){
        boolean digit = true;
        Number num = new Number(5); // 101
        Iterator<Bit> iter = num.bitIterator();
        Bit bit;

        // Test 1
        if(!iter.hasNext())
            return false;


        // Test 2
        while(iter.hasNext()) {
            bit = iter.next();
            if (bit.getValue() != digit)
                return false;
            digit = !digit;
        }

        // Test 3
        num = new Number(512);  // 10 digit binary number
        iter = num.bitIterator();
        int counter = 0;
        while(iter.hasNext()) {
            bit = iter.next();
            counter++;
        }
        if(counter != 10)
            return false;

        return true;
    }


    public static boolean testIncrement(){
        Number num1 = new Number(10);
        Number num2 = new Number(12);
        num1.increment();
        num1.increment();
        num1.increment(); // num1 = 13

        if(num1.equals(num2))
            return false;

        num2.increment(); // num2 = 13

        if(!(num1.equals(num2)))
            return false;

        return true;

    }


    public static boolean testIsLegal(){

        if(!(Number.isLegal("123890")))
            return false;
        if(Number.isLegal(""))
            return false;
        if(Number.isLegal("023890"))
            return false;
        if(Number.isLegal("-123890"))
            return false;
        if(Number.isLegal("123&90"))
            return false;

        return true;
    }


    public static boolean testEquals(){
        Number num1 = new Number(7);
        Number num2 = new Number(10);

        if(num1.equals(num2))
            return false;

        num1 = new Number(10);

        if(!(num1.equals(num2)))
            return false;

        return true;
    }

    public static boolean testToString(){
        Number num1 = new Number();
        Number num2 = new Number(45);

        if(!("0".equals(num1.toString())))
            return false;

        if(!("101101".equals(num2.toString())))
            return false;

        return true;

    }


    public static boolean testLessEq(){
        Number num1 = new Number(13);
        Number num2 = new Number(14);
        if(!Number.lessEq(num1, num2))
            return false;
        if(Number.lessEq(num2, num1))
            return false;
        if(!Number.lessEq(num2, num2))
            return false;

        return true;
    }


    public static boolean testLessThan(){
        Number num1 = new Number(13);
        Number num2 = new Number(14);
        if(!Number.lessThan(num1, num2))
            return false;
        if(Number.lessThan(num2, num1))
            return false;
        if(Number.lessThan(num2, num2))
            return false;

        return true;
    }


    public static boolean testCompareTo(){
        Number num1 = new Number(13);
        Number num2 = new Number(14);
        if(num1.compareTo(num2) >= 0)
            return false;
        if(num2.compareTo(num1) <= 0)
            return false;
        if(num1.compareTo(num1) != 0)
            return false;

        return true;
    }


    public static boolean testAdd(){
        Number num1 = new Number(16);
        Number num2 = new Number(21);
        Number sum = new Number (37);
        Number zero = new Number();

        if(!(Number.add(num1, num2).equals(sum)))
            return false;

        if(!(Number.add(num1, zero).equals(num1)))
            return false;

        return true;

    }

    public static boolean testMultiply(){
        Number num1 = new Number(5);
        Number num2 = new Number(7);
        Number multiplication = new Number (35);
        Number zero = new Number();

        if(!(Number.multiply(num1, num2).equals(multiplication)))
            return false;

        if(!(Number.multiply(num1, zero).equals(zero)))
            return false;

        return true;

    }
}

import java.util.Iterator;

public class Number implements Comparable<Number> {
    private static final int BASE = 2;
    private static final Number ZERO = new Number();
    private static final Number ONE = new Number(1);
    private List<Bit> list;

    /**
     * Constructs a new Number defaulted to the value zero.
     */
    public Number() {
        list = new LinkedList<Bit>();
        list.add(new Bit(false));
    }

    /**
     * Constructs a new Number from an int.
     *
     * @param number an int representing a decimal number
     */
    public Number(int number) {  // assignment #1
        {

            if (number < 0)
                throw new IllegalArgumentException();

            list = new LinkedList<Bit>();

            if (number == 0)
                list.add(new Bit(false));

            while (number != 0) {
                if (number % 2 == 0)
                    list.add(new Bit(false));
                else
                    list.add(new Bit(true));
                number = number / 2;
            }
        }
    }

    /**
     * Constructs a new Number from a String.
     *
     * @param s a String (possibly) representing a decimal number.
     */
    public Number(String s) {    // assignment #2

        int digit, num = 0, digitIndex = 1;

        // Input validations:
        if (s == null || s.length() == 0)           // String is null or Empty
            throw new IllegalArgumentException();

        if (s.length() > 1 & s.charAt(0) == '0')      // Number starts with 0 and not 0.
            throw new IllegalArgumentException();

        for (int i = 0; i < s.length(); i++) {        // String contains invalid character
            if (s.charAt(i) < '0' || s.charAt(i) > '9')
                throw new IllegalArgumentException();
        }

        // Converting the input string to an integer
        for (int i = s.length() - 1; i >= 0; i--) {
            digit = s.charAt(i) - '0';
            num = num + digit * digitIndex;
            digitIndex = digitIndex * 10;
        }

        updateNumber(num);

    }

    // Updating class number without triggering the constructor
    public void updateNumber(int num) {

        list = new LinkedList<Bit>();

        if (num == 0)
            list.add(new Bit(false));

        while (num != 0) {
            if (num % 2 == 0)
                list.add(new Bit(false));
            else
                list.add(new Bit(true));
            num = num / 2;
        }
    }

    /**
     * Constructs a new Number which is a deep copy of the provided Number.
     *
     * @param number a Number to be copied
     */
    public Number(Number number) { // assignment #3
        list = new LinkedList<Bit>();
        int index = 0;

        while (index < number.list.size()) {
            list.add(number.list.get(index));
            index++;
        }
    }

    /**
     * Checks if this Number is zero.
     *
     * @return true if and only if this object representing the number zero.
     */
    public boolean isZero() { // assignment #4
        // Using the methods of LinkedList, Checking whether Number contains one link with the value 0
        if (this.list.size() == 1 && !(this.list.get(0).getValue()))
            return true;
        return false;
    }


    /**
     * Returns an iterator over the Bit objects in the representation of this number,
     * which iterates over the Bit objects from LSB (first) to MSB (last).
     *
     * @return a LSB-first iterator over the Bit objects in the representation of this number.
     */
    public Iterator<Bit> bitIterator() { // assignment #5
        return this.list.iterator();
    }


    /**
     * Adds 1 to the number
     */
    public void increment() { // assignment #6
        int power = 0;
        int num = 0;
        Iterator<Bit> iter = this.bitIterator();

        // Converting from base 2 to base 10
        while (iter.hasNext()) {
            Bit bit = iter.next();    // Saving the bit in the next iterator loop
            if (bit.getValue())      // Means the current link contains '1'
                num = num + (int) Math.pow(2, power);
            power++;
        }

        // Incrementing base 10 number by 1
        num = num + 1;

        updateNumber(num);
    }


    /**
     * Checks if a provided String represent a legal decimal number.
     *
     * @param s a String that possibly represents a decimal number, whose legality to be checked.
     * @return true if and only if the provided String is a legal decimal number
     */
    public static boolean isLegal(String s) { // assignment #7

        if (s == null || s.length() == 0)           // String is null or Empty
            return false;

        if (s.charAt(0) == '0')      // Number starts with 0
            return false;

        for (int i = 0; i < s.length(); i++) {      // String contains invalid character
            if (s.charAt(i) < '0' || s.charAt(i) > '9')
                return false;
        }

        return true;
    }


    /**
     * Compares the specified object with this Number for equality.
     * Returns true if and only if the specified object is also a
     * Number (object) which represents the same number.
     *
     * @param obj he object to be compared for equality with this Number
     * @return true if and only if the specified object is equal to this object
     */
    public boolean equals(Object obj) { // assignment #8

        // Validating input object is of Number instance
        if (!(obj instanceof Number))
            return false;

        // Validating input object has the same size as the current Number
        if (((Number) obj).list.size() != this.list.size())
            return false;

        Iterator<Bit> currNumIter = this.bitIterator();
        Iterator<Bit> inputNumIter = ((Number) obj).bitIterator();
        Bit currNumBit, inputNumBit;

        // Validating that each Bit inside the 2 numbers is equal
        while (currNumIter.hasNext()) {
            currNumBit = currNumIter.next();
            inputNumBit = inputNumIter.next();
            if (currNumBit.getValue() != inputNumBit.getValue())
                return false;
        }

        return true;

    }


    /**
     * Returns a string representation of this Number
     * as a binary number.
     *
     * @return a string representation of this Number
     */
    public String toString() { // assignment #9

        int size = this.list.size();
        String str = "";

        for (int i = size - 1; i >= 0; i--) {
            if (this.list.get(i).getValue())
                str = str + "1";
            else
                str = str + "0";
        }

        return str;
    }


    /**
     * Compares the two provided numbers, and returns true if
     * the first parameter is less than or equal to the second
     * parameter, as numbers.
     *
     * @param num1 the first number to compare
     * @param num2 the second number to compare
     * @return true if and only if the first number is less than
     * or equal to the second parameter, as numbers.
     */
    public static boolean lessEq(Number num1, Number num2) { // assignment #10

        boolean isNum1DigitSmaller = true;
        Iterator<Bit> num1Iter = num1.bitIterator();
        Iterator<Bit> num2Iter = num2.bitIterator();
        Bit num1Bit, num2Bit;

        // Going through the digits of the 2 numbers
        while (num1Iter.hasNext() & num2Iter.hasNext()) {
            num1Bit = num1Iter.next();
            num2Bit = num2Iter.next();

            // isNum1DigitSmaller gets true at the end of the loops only if the MSB (or near MSB) of num1 is indeed smaller
            if (num1Bit.isZero() & num2Bit.isOne())
                isNum1DigitSmaller = true;
            if (num1Bit.isOne() & num2Bit.isZero())
                isNum1DigitSmaller = false;
        }

        // num1 is longer than num2, therefore num1 > num2
        if(num1Iter.hasNext() & !(num2Iter.hasNext()))
            return false;
        // num2 is longer than num1, therefore num1 < num2
        else if (!(num1Iter.hasNext()) & num2Iter.hasNext())
            return true;
        // The numbers are at the same size, but num1 has a bigger digit
        else if (!(isNum1DigitSmaller))
            return false;

        // Numbers are equal, or Numbers at the same size but num1 is still smaller
        return true;
    }


    /**
     * Compares the two provided numbers, and returns true if
     * the first parameter is strictly less than the second
     * parameter, as numbers.
     *
     * @param num1 the first number to compare
     * @param num2 the second number to compare
     * @return true if and only if the first number is strictly
     * less than the second parameter, as numbers.
     */
    public static boolean lessThan(Number num1, Number num2) { // assignment #11
        boolean isNum1DigitSmaller = true, isEqual = true;
        Iterator<Bit> num1Iter = num1.bitIterator();
        Iterator<Bit> num2Iter = num2.bitIterator();
        Bit num1Bit, num2Bit;

        // Going through the digits of the 2 numbers
        while (num1Iter.hasNext() & num2Iter.hasNext()) {
            num1Bit = num1Iter.next();
            num2Bit = num2Iter.next();

            // isNum1DigitSmaller gets true at the end of the loops only if the MSB (or near MSB) of num1 is indeed smaller
            if (num1Bit.isZero() & num2Bit.isOne()) {
                isNum1DigitSmaller = true;
                isEqual = false;
            }
            if (num1Bit.isOne() & num2Bit.isZero()) {
                isNum1DigitSmaller = false;
                isEqual = false;
            }
        }

        // num1 is longer than num2, therefore num1 > num2
        if(num1Iter.hasNext() & !(num2Iter.hasNext()))
            return false;
        // num2 is longer than num1, therefore num1 < num2
        else if (!(num1Iter.hasNext()) & num2Iter.hasNext())
            return true;
        // The numbers are at the same size, but num1 has a bigger digit
        else if (!(isNum1DigitSmaller))
            return false;

        // If numbers are equal
        if(isEqual)
            return false;

        // Numbers at the same size, but num1 is still smaller
        return true;
    }


    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Number o) { // assignment #12

        // Numbers are equal
        if(o.equals(this))
            return 0;

        // Input number is smaller
        if(Number.lessThan(this, o))
            return -1;

        // Input number is bigger
        return 1;

    }


    /**
     * Adds the specified Number objects, and returns their sum.
     *
     * @param num1 the first addend
     * @param num2 the second addend
     * @return the sum of the specified Number objects.
     */
    public static Number add(Number num1, Number num2) { // assignment #13

        Number sum = new Number();
        Bit zero = new Bit(false);
        Bit one = new Bit(true);
        sum.list.remove(zero);      // Creating null linkedList

        Bit A = new Bit();
        Bit B = new Bit();
        Bit Cin = new Bit(false);

        Iterator<Bit> num1Iter = num1.bitIterator();
        Iterator<Bit> num2Iter = num2.bitIterator();

        while (num1Iter.hasNext() || num2Iter.hasNext()) {

            // If one the numbers is shorter, initializing its remainder with 0 Bits so it won't affect the summation
            if(num1Iter.hasNext())
                A = num1Iter.next();
            else
                A.setValue(false);
            if(num2Iter.hasNext())
                B = num2Iter.next();
            else
                B.setValue(false);

            sum.list.add(Bit.fullAdderSum(A, B, Cin));

            if(Bit.fullAdderCarry(A, B, Cin).getValue())
                Cin.setValue(true);
            else
                Cin.setValue(false);

        }

        if(Cin.getValue())
            sum.list.add(one);

        return sum;

    }


    /**
     * Multiply the specified Number objects, and returns their product.
     *
     * @param num1 the first factor
     * @param num2 the second factor
     * @return the product of the specified Number objects.
     */
    public static Number multiply(Number num1, Number num2) { // assignment #14

        Number digitMultiply = new Number();        // Multiply of a single digit of num1 by all of num2
        Number multiply = new Number();
        Bit zero = new Bit(false);
        Bit one = new Bit(true);
        digitMultiply.list.remove(zero); // Creating null linkedList

        Iterator<Bit> num1Iter = num1.bitIterator();
        Iterator<Bit> num2Iter = num2.bitIterator();

        int zeroCounter = 0;

        while (num1Iter.hasNext()) {
            {
                Bit num1Digit = num1Iter.next();
                while (num2Iter.hasNext()) {
                    Bit num2Digit = num2Iter.next();
                    if (num1Digit.isOne() & num2Digit.isOne())
                        digitMultiply.list.add(one);
                    else
                        digitMultiply.list.add(zero);
                }

                // Summing digitMultiply inside multiply
                multiply = add(multiply, digitMultiply);

                //Resetting digitMultiply and adding zeros at the beginning for the next multiplication
                digitMultiply = new Number();
                digitMultiply.list.remove(zero);
                zeroCounter++;
                for(int i=0; i<zeroCounter; i++)
                    digitMultiply.list.add(zero);

                //Resetting num2 iterator
                num2Iter = num2.bitIterator();
            }
        }

        // Validates that there's no '0000' scenarios   >> Converting multiply to '0' if it does
        if (!multiply.list.get((multiply.list.size())-1).getValue())
            multiply = new Number();

        return multiply;
    }
}

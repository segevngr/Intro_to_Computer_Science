/*---------------------------------------
 Genuine author: Segev Nagar, I.D.: 312529316
 Date: 29-12-2018
---------------------------------------*/

import java.util.Iterator;

public class PrimeIterator implements Iterator<Integer> {

    private List<Integer> primes;

    //Complete the following method
    public PrimeIterator() {
        primes = new LinkedList<Integer>();     // Initializing primes as a Linked List
    }

    //Complete the following method
    public boolean hasNext() {
        return true;    // There's an infinite number of primes, therefore there will always be next number
    }

    //Complete the following method
    public Integer next() {
        // If there are no links yet, 2 as the first prime number is added
        if (primes.isEmpty())
            primes.add(2);
        else {
            int lastPrime = primes.get(primes.size() - 1);  // Holds the biggest \ last prime number currently in primes
            // Finding out whats the following prime number using an external function, and returning it at the end.
            boolean found = false;
            while (!found) {
                lastPrime++;
                if (isPrime(lastPrime))
                    found = true;
            }
            primes.add(lastPrime);
        }
        return primes.get(primes.size() - 1);
    }

    //DO NOT REMOVE OR CHANGE THIS MEHTOD – IT IS REQUIRED
    public void remove() {
        return;
    }

    // Boolean function that gets a number and returns true if its a prime number
    private Boolean isPrime(int num) {
        boolean isPrime = true;
        int i = 2;
        while (i * i <= num & isPrime) {
            if (num % i == 0)
                isPrime = false;
            i++;
        }
        return isPrime;
    }


}

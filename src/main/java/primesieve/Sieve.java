package primesieve;

/**
 * Represents the Sieve of Eratosthenes
 * @author tthenshaw
 */

public class Sieve {

    public static void main(String[] args) {

        // Define max to check to.
        int size = 500;

        // Boolean array to hold primes.  size+1 as 0-based indices.  Assuming all initially prime, so init to true.
        // Each array index will represent its actual number.
        boolean[] primes = new boolean[size + 1];
//        Arrays.fill(primes, true);

        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }

        // 0 and 1 cannot be prime
        primes[0] = false;
        primes[1] = false;

        // Iterate through to limit of sqrt(size);  Avoid expensive .sqrt() operation via simple multiplication.
        for (int i = 2; i * i <= size; i++) {
            if (primes[i]) {
                // Sets all multiples to prime
                for (int j = i * 2; j <= size;  j += i) {
                    primes[j] = false;
                }
            }
        }

        printPrimes(primes);
    }

    public static void printPrimes(boolean[] primes) {
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                System.out.println(i);
            }
        }
    }
}

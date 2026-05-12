package week04.day2;

import java.util.Arrays;

public class Answer4 {
    public static void main(String[] args) {
        int[] primes = getPrimes(20);
        System.out.println("20까지의 소수: " + Arrays.toString(primes));
    }

    public static int[] getPrimes(int n) {
        int[] temp = new int[n];
        int count = 0;
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) temp[count++] = i;
        }
        return Arrays.copyOf(temp, count);
    }
}

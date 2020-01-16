package recursivedemo;

import java.util.Random;

/**
 * @author shmilyiselephant
 * @date 10.01.20
 * @decription
 */
public class RecursiveDemo {
    public static int fibo(int n) {
        return n < 2 ? 1 : fibo(n-1) + fibo(n-2);
    }

    public static int factorial(int n) {
        return n < 2 ? 1 : n*factorial(n-1);
    }

    public static void main(String args[]) {
        Random r = new Random();
        int rInt = r.nextInt(10);
        System.out.printf("fibo(%d)=%d%n", rInt, fibo(rInt));
        System.out.printf("factorial(%d)=%d%n", rInt, factorial(rInt));
    }
}

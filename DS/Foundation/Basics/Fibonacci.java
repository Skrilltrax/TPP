package DS.Foundation.Basics;

import java.util.*;

public class Fibonacci {

    public static void main(String[] args) {
        // write your code here

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        fibIterative(n);
    }

    public static void fibIterative(int n) {
        int a = 0;
        int b = 1;
        int c = a + b;

        if (n >= 1) {
            System.out.println(a);
        }

        if (n >= 2) {
            System.out.println(b);
        }

        n -= 2;

        while (n-- > 0) {
            System.out.println(c);
            a = b;
            b = c;
            c = a + b;
        }
    }
}
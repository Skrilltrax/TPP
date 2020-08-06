import java.io.*;
import java.util.*;

public class ClimbStairMinMove {

    public static void main(String[] args) throws Exception {
        // write your code here
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] dp = new int[n + 1];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            dp[n] = 1;

            for (int i = n - 1; i >= 0; i--) {
                dp[i] = (int) 10e6;
                for (int j = 1; i + j <= n && j <= arr[i]; j++) {
                    dp[i] = Math.min(dp[i], dp[i + j]);
                }
                dp[i]++;
            }

            if (dp[0] >= 10e6) {
                System.out.println("null");
            } else {
                System.out.println(dp[0] - 1);
            }
        }
    }

}
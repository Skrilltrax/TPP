import java.io.*;
import java.util.*;

public class CountBinaryStrings {

    public static void main(String[] args) throws Exception {
        // write your code here
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[][] dp = new int[2][n + 1];

            System.out.println(countBinary(n, dp));
        }
    }

    public static int countBinary(int n, int[][] dp) {
        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[0][1] = 1;
        dp[1][1] = 1;

        for (int i = 2; i < dp[0].length; i++) {
            dp[1][i] = dp[0][i - 1] + dp[1][i - 1];
            dp[0][i] = dp[1][i - 1];

        }

        return dp[0][n] + dp[1][n];
    }

}
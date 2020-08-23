package DP;

import java.util.*;

public class Tiling21 {

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[][] dp = new int[2][n + 1];

            System.out.println(tiling21(n, dp));
        }
    }

    public static int tiling21(int n, int[][] dp) {
        dp[0][1] = 1; // vertical
        dp[1][1] = 0; // horizontal
        dp[0][2] = 1; // vertical
        dp[1][2] = 1; // horizontal

        for (int i = 3; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
            dp[1][i] = dp[0][i - 2] + dp[1][i - 2];
        }

        return dp[0][n] + dp[1][n];
    }
}
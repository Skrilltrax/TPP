import java.io.*;
import java.util.*;

public class ZeroOneKnapsack {

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {

            int n = sc.nextInt();
            int[][] items = new int[n][2];

            for (int i = 0; i < n; i++) {
                items[i][0] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                items[i][1] = sc.nextInt();
            }

            int cap = sc.nextInt();

            int[][] dp = new int[n + 1][cap + 1];

            System.out.println(knapsack(items, cap, dp));
        }
    }

    private static int knapsack(int[][] items, int cap, int[][] dp) {
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j - items[i - 1][1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], (dp[i - 1][j - items[i - 1][1]]) + items[i - 1][0]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[items.length][cap];
    }
}
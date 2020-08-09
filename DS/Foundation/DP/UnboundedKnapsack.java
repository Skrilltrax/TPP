import java.io.*;
import java.util.*;

public class UnboundedKnapsack {

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

            int[] dp = new int[cap + 1];

            System.out.println(knapsack(items, cap, dp));
        }
    }

    public static int knapsack(int[][] items, int cap, int[] dp) {

        for (int i = 0; i < items.length; i++) {
            for (int j = items[i][1]; j < dp.length; j++) {
                dp[j] = Math.max(dp[j], items[i][0] + dp[j - items[i][1]]);
            }
        }

        return dp[cap];
    }
}
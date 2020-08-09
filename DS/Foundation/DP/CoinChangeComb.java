import java.io.*;
import java.util.*;

public class coinChangeComb {

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int tar = sc.nextInt();

            int[] dp = new int[tar + 1];

            System.out.println(coinChangeTab(arr, tar, dp));
        }

    }

    private static int coinChangeTab(int[] arr, int tar, int[] dp) {
        dp[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j < dp.length; j++) {
                if (j - arr[i] >= 0) {
                    dp[j] += dp[j - arr[i]];
                }
            }
        }

        return dp[tar];
    }
}
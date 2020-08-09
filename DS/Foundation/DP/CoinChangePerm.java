import java.io.*;
import java.util.*;

public class coinChangePerm {

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
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if (i - arr[j] >= 0) {
                    dp[i] += dp[i - arr[j]];
                }
            }
        }
        
        return dp[tar];
    }
}
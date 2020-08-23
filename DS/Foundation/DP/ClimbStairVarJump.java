package DP;

import java.util.*;

public class ClimbStairVarJump {

    public static void main(String[] args) throws Exception {
        // write your code here
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] dp = new int[n + 1];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(climbStairsVarTab(n, arr, dp));
        }
    }

    public static int climbStairsVarTab(int n, int[] arr, int[] dp) {
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; i + j <= n && j <= arr[i]; j++) {
                dp[i] += dp[i + j];
            }
        }

        return dp[0];
    }

    public static int climbStairsVarRec(int idx, int[] arr) {
        if (idx > arr.length)
            return 0;
        if (idx == arr.length)
            return 1;

        if (arr[idx] == 0)
            return 0;

        int ans = 0;

        for (int i = 1; i <= arr[idx]; i++) {
            ans += climbStairsVarRec(idx + i, arr);
        }

        return ans;
    }

}
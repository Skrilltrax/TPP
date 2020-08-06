import java.io.*;

import java.util.*;

public class ClimbStairs {


    public static void main(String[] args) throws Exception {
        // write your code here
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] dp = new int[n + 1];

            System.out.println(climbStairsMemo(n, dp));
        }       
    }

    public static int climbStairsRec(int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) return 1;

        int ans = 0;

        for(int i = 1; i <= 3; i++) {
            ans += climbStairsRec(n - i);
        }

        return ans;
    }

    public static int climbStairsMemo(int n, int[] dp) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) return 1;

        if (dp[n] != 0) return dp[n];

        int ans = 0;

        for(int i = 1; i <= 3; i++) {
            ans += climbStairsRec(n - i);
        }

        return dp[n] = ans;
    }

    public static int climbStairsTab(int n, int[] dp) {
        for(int i = 0; i <= n; i++) {
            if (i == 0) {
                dp[i] = 1;
                continue;
            }
            
            int ans = 0;

            for(int j = 1; j <= 3; j++) {
                if (i - j >= 0) {
                    ans += dp[i - j];                    
                }
            }

            dp[i] = ans;
        }

        return dp[n];
    }
}

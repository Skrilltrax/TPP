package DP;

import java.util.*;

public class GoldMine {

    public static void main(String[] args) throws Exception {
        // write your code here
        try (Scanner sc = new Scanner(System.in)) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int[][] arr = new int[r][c];
            int[][] dp = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    arr[i][j] = sc.nextInt();
                    dp[i][j] = -1;
                }
            }

            // int ans = 0;
            // for(int i = 0; i < r; i++) {
            // ans = Math.max(ans, goldMineMemo(arr, i, 0, dp));
            // }

            // System.out.println(ans);

            System.out.println(goldMineTab(arr, dp));
        }
    }

    private static int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

    public static boolean isSafe(int[][] arr, int r, int c) {
        if (r < 0 || r >= arr.length || c >= arr[0].length) {
            return false;
        }

        return true;
    }

    public static int goldMine(int[][] arr, int r, int c) {
        if (c == arr[0].length - 1) {
            return arr[r][c];
        }

        int ans = 0;

        for (int i = 0; i < dir.length; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if (isSafe(arr, nr, nc)) {
                ans = Math.max(ans, goldMine(arr, nr, nc));
            }
        }

        ans += arr[r][c];

        return ans;
    }

    public static int goldMineMemo(int[][] arr, int r, int c, int[][] dp) {
        if (c == arr[0].length - 1) {
            return dp[r][c] = arr[r][c];
        }

        if (dp[r][c] != -1)
            return dp[r][c];
        int ans = 0;

        for (int i = 0; i < dir.length; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if (isSafe(arr, nr, nc)) {
                ans = Math.max(ans, goldMine(arr, nr, nc));
            }
        }

        ans += arr[r][c];

        return dp[r][c] = ans;
    }

    public static int goldMineTab(int[][] arr, int[][] dp) {

        for (int j = arr[0].length - 1; j >= 0; j--) {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (j == arr[0].length - 1) {
                    dp[i][j] = arr[i][j];
                    continue;
                }

                dp[i][j] = dp[i][j + 1];

                if (i - 1 >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j + 1]);
                }

                if (i + 1 < arr.length) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j + 1]);
                }

                dp[i][j] += arr[i][j];
            }
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, dp[i][0]);
        }

        return max;
    }

}
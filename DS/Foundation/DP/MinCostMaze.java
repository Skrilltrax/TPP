package DP;

import java.util.*;

public class MinCostMaze {

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

            System.out.println(solveTab(arr, dp));
        }
    }

    public static int[][] dir = { { 1, 0 }, { 0, 1 } };

    public static boolean isSafe(int[][] arr, int r, int c) {
        if (r >= arr.length || c >= arr[0].length) {
            return false;
        }

        return true;
    }

    public static int solveRec(int[][] arr, int r, int c) {
        if (r == arr.length - 1 && c == arr[0].length - 1) {
            return arr[r][c];
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < dir.length; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if (isSafe(arr, nr, nc)) {
                ans = Math.min(ans, solveRec(arr, nr, nc));
            }
        }

        ans += arr[r][c];

        return ans;
    }

    public static int solveMemo(int[][] arr, int r, int c, int[][] dp) {
        if (r == arr.length - 1 && c == arr[0].length - 1) {
            return dp[r][c] = arr[r][c];
        }

        if (dp[r][c] != -1)
            return dp[r][c];

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < dir.length; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if (isSafe(arr, nr, nc)) {
                ans = Math.min(ans, solveMemo(arr, nr, nc, dp));
            }
        }

        ans += arr[r][c];

        return dp[r][c] = ans;
    }

    public static int solveTab(int[][] arr, int[][] dp) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr[0].length - 1; j >= 0; j--) {
                if (i == arr.length - 1 && j == arr[0].length - 1) {
                    dp[i][j] = arr[i][j];
                    continue;
                }

                dp[i][j] = Integer.MAX_VALUE;

                if (i + 1 < arr.length) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j]);
                }

                if (j + 1 < arr[0].length) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1]);
                }

                dp[i][j] += arr[i][j];
            }
        }

        return dp[0][0];
    }

}
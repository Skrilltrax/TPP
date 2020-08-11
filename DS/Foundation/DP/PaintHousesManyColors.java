import java.io.*;
import java.util.*;

public class PaintHousesManyColors {

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int c = sc.nextInt();

            int[][] arr = new int[n][c];
            int[][] dp = new int[n][c];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < c; j++) {
                    arr[i][j] = sc.nextInt();
                    if (i == 0)
                        dp[i][j] = arr[i][j];
                }
            }

            System.out.println(paintHouseMany(n, c, arr, dp));
        }
    }

    public static int paintHouseMany(int n, int c, int[][] arr, int[][] dp) {
        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;

        for (int j = 0; j < c; j++) {
            int i = 0;

            if (dp[i][j] < min) {
                smin = min;
                min = dp[i][j];
            } else if (dp[i][j] >= min && dp[i][j] < smin) {
                smin = dp[i][j];
            }
        }

        for (int i = 1; i < n; i++) {
            int nMin = Integer.MAX_VALUE;
            int nsMin = Integer.MAX_VALUE;

            for (int j = 0; j < c; j++) {

                if (dp[i - 1][j] == min) {
                    dp[i][j] = arr[i][j] + smin;
                } else {
                    dp[i][j] = arr[i][j] + min;
                }

                if (dp[i][j] < nMin) {
                    nsMin = nMin;
                    nMin = dp[i][j];
                } else if (dp[i][j] >= nMin && dp[i][j] < nsMin) {
                    nsMin = dp[i][j];
                }
            }

            min = nMin;
            smin = nsMin;
        }

        // for(int i = 0; i < n; i++) {
        // for(int j = 0; j < c; j++) {
        // System.out.print(dp[i][j] + " ");
        // }
        // System.out.println();
        // }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < c; j++) {
            if (dp[n - 1][j] < ans)
                ans = dp[n - 1][j];
        }

        return ans;
    }

}
import java.io.*;
import java.util.*;

public class PaintHouses {

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();

            int[][] arr = new int[n][3];

            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
                arr[i][2] = sc.nextInt();
            }

            int[][] dp = new int[3][n + 1];

            System.out.println(paintHouses(n, arr, dp));
        }
    }

    public static int paintHouses(int n, int[][] arr, int[][] dp) {

        for (int j = 1; j < dp[0].length; j++) {
            for (int i = 0; i < dp.length; i++) {
                if (i == 0) {
                    dp[i][j] = arr[j - 1][i] + Math.min(dp[1][j - 1], dp[2][j - 1]);
                } else if (i == 1) {
                    dp[i][j] = arr[j - 1][i] + Math.min(dp[0][j - 1], dp[2][j - 1]);
                } else {
                    dp[i][j] = arr[j - 1][i] + Math.min(dp[0][j - 1], dp[1][j - 1]);
                }
            }
        }

        return Math.min(dp[0][n], Math.min(dp[1][n], dp[2][n]));
    }
}
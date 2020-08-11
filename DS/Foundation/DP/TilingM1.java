import java.io.*;
import java.util.*;

public class TilingM1 {

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] dp = new int[2][n + 1];

            System.out.println(tilingm1(n, m, dp));
        }
    }

    public static int tilingm1(int n, int m, int[][] dp) {
        if (m > n)
            return 1;

        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
            dp[1][i] = 0;
        }

        dp[0][m] = 1;
        dp[1][m] = 1;

        for (int i = m + 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
            dp[1][i] = dp[0][i - m] + dp[1][i - m];
        }

        return dp[0][n] + dp[1][n];
    }
}
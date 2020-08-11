import java.io.*;
import java.util.*;

public class PaintFences {

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int c = sc.nextInt();

            int[][] dp = new int[3][n];

            System.out.println(paintFences(n, c, dp));
        }
    }

    public static int paintFences(int n, int c, int[][] dp) {
        dp[0][0] = 0;
        dp[1][0] = c;
        dp[2][0] = c;

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[1][j - 1];
            dp[1][j] = dp[2][j - 1] * (c - 1);
            dp[2][j] = dp[0][j] + dp[1][j];
        }

        return dp[2][n - 1];
    }
}
import java.io.*;
import java.util.*;

public class CountABCSubsequences {

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            String str = sc.nextLine();

            int[][] dp = new int[4][str.length() + 1];

            System.out.println(abcSubsequences(str, dp));
        }
    }

    public static int abcSubsequences(String str, int[][] dp) {

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 1;
        }

        for (int j = 1; j < dp[0].length; j++) {
            char ch = str.charAt(j - 1);
            for (int i = 1; i <= 3; i++) {

                if (i == (ch - 'a' + 1)) {
                    dp[i][j] = 2 * dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        // for(int i = 0; i < dp.length; i++) {
        // for(int j = 0; j < dp[0].length; j++) {
        // System.out.print(dp[i][j] + " ");
        // }
        // System.out.println();
        // }

        return dp[3][str.length()];
    }

    public static int abcSubsequencesOpt(String str) {
        int a = 0, ab = 0, abc = 0;

        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                a = 2 * a + 1;
            }
            
            if (str.charAt(i) == 'b') {
                ab = 2 * ab + a;
            }
            
            if (str.charAt(i) == 'c') {
                abc = 2 * abc + ab;
            }
        }
        return abc;
    }
}
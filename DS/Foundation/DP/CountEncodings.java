import java.io.*;
import java.util.*;

public class countEncodings {

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {

            String str = sc.nextLine();
            int[] dp = new int[str.length()];

            System.out.println(countEncodingsTab(str, dp));
        }
    }

    public static int countEncodingsRec(String str, int idx, String ans) {
        if (idx == str.length()) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        int n1 = (str.charAt(idx) - '0');

        if (n1 == 0)
            return 0;
        count += countEncodingsRec(str, idx + 1, ans + ((char) n1 + 'a'));

        if (idx + 1 != str.length()) {
            int n2 = (str.charAt(idx + 1) - '0');
            int combinedNum = n1 * 10 + n2;

            if (combinedNum > 0 && combinedNum <= 26) {
                count += countEncodingsRec(str, idx + 2, ans + ((char) combinedNum + 'a'));
            }
        }

        return count;
    }

    public static int countEncodingsMemo(String str, int idx, String ans, int[] dp) {
        if (idx == str.length()) {
            // System.out.println(ans);
            return 1;
        }

        if (dp[idx] != 0)
            return dp[idx];

        int count = 0;
        int n1 = (str.charAt(idx) - '0');

        if (n1 == 0)
            return 0;
        count += countEncodingsMemo(str, idx + 1, ans + ((char) n1 + 'a'), dp);

        if (idx + 1 != str.length()) {
            int n2 = (str.charAt(idx + 1) - '0');
            int combinedNum = n1 * 10 + n2;

            if (combinedNum > 0 && combinedNum <= 26) {
                count += countEncodingsMemo(str, idx + 2, ans + ((char) combinedNum + 'a'), dp);
            }
        }

        return dp[idx] = count;
    }

    public static int countEncodingsTab(String str, int[] dp) {
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            int n1 = (str.charAt(i - 1) - '0');
            int n2 = (str.charAt(i) - '0');

            // System.out.println("n1 : " + n1 + " n2 : " + n2);

            if (n1 == 0 && n2 == 0) {
                dp[i] = 0;
            } else if (n1 == 0 && n2 != 0) {
                dp[i] = dp[i - 1];
            } else if (n1 != 0 && n2 == 0) {
                if (n1 * 10 + n2 <= 26) {
                    dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                } else {
                    dp[i] = 0;
                }
            } else {
                if (n1 * 10 + n2 <= 26) {
                    dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }

        return dp[str.length() - 1];
    }
}
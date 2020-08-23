import java.io.*;
import java.util.*;

public class FriendPairing {

    public static void main(String[] args) throws Exception {
        // write your code here
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] dp = new int[n + 1];
            
            System.out.println(friendPairing(n, dp));
        }
    }
    
    public static int friendPairing(int n, int[] dp) {
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        
        // If we do not want to pair we can do so in dp[i-1] ways by adding ourself to all the previous combinations
        // If we want to pair, we can pair with (i - 1) elements and for each pair remaining 
        // elements can be formed in dp[i - 2] ways  

        for(int i = 3; i <= dp.length; i++) {
            dp[i] = dp[i-1] +  dp[i-2] * (i-1);
        }
        
        return dp[n];
    }

}
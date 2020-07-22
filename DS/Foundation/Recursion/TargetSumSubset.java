import java.util.*;

public class TargetSumSubset {

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int tar = sc.nextInt();
            printTargetSumSubsets(arr, 0, "", 0, tar);
            System.out.println();
        }
    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        if (idx == arr.length) {
            return;
        }

        if (arr[idx] + sos <= tar) {
            printTargetSumSubsets(arr, idx + 1, set + arr[idx] + ", ", sos + arr[idx], tar);
        }

        printTargetSumSubsets(arr, idx + 1, set, sos, tar);

        if (arr[idx] + sos == tar) {
            System.out.println(set + arr[idx] + ", " + ".");
            return;
        }
    }

}
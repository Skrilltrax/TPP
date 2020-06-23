public class PrintSubsetsArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        printSubsets(arr);
    }

    public static void printSubsets(int[] arr) {
        int n = arr.length;

        int subsLen = (int) Math.pow(2, n);
        for (int i = 0; i < subsLen; i++) {
            String subset = "";
            for(int j = 0; j < n; j++) {
                int mask = 1 << j;
                if((mask & i) != 0) {
                    subset += arr[j];
                }
            }
            System.out.println(subset);
        }
    }
}
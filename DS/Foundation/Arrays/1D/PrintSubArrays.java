public class PrintSubArrays {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        printSubArraysBetter(arr);
    }

    public static void printSubArrays(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void printSubArraysBetter(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            String str = "";
            for (int j = i; j < n; j++) {
                str += arr[j] + " ";
                System.out.println(str);
            }
        }
    }
}
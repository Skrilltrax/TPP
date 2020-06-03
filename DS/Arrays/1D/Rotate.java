public class Rotate {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = -3;

        rotate(arr, k);

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        if (k < 0) {
            k += arr.length;
        } else if (k == 0) {
            return;
        }

        reverse(arr, 0, arr.length - 1 - k);
        reverse(arr, arr.length - k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    public static void reverse(int[] arr, int li, int ri) {
        if (ri <= li) {
            return;
        }

        while(li < ri) {
            int tmp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = tmp;
            li++;
            ri--;
        }
    }
}
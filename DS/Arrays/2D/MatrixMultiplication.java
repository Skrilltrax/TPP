public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] arr1 = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } };
        int[][] arr2 = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } };

        int[][] ans = multiply(arr1, arr2);

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] multiply(int[][] arr1, int[][] arr2) {
        int r1 = arr1.length;
        int c1 = arr1[0].length;

        int r2 = arr2.length;
        int c2 = arr2[0].length;

        int[][] ans = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                int sum = 0;
                for (int k = 0; k < r2; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                ans[i][j] = sum;
            }
        }

        return ans;
    }
}
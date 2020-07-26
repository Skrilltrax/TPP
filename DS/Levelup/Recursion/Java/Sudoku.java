public class Sudoku {

    public static int[] rowArr = new int[9];
    public static int[] colArr = new int[9];
    public static int[][] matArr = new int[3][3];

    public static boolean isSafeBetter(int[][] arr, int r, int c, int num) {
        if (arr.length != 9 || arr[0].length != 9 || arr[r][c] != 0  || r <= 0 || r >= 9 || c <= 0 || c >= 9) {
            return false;
        }

        if ((rowArr[r] & (1 << num)) != 0) {
            return false;
        }

        if ((colArr[c] & (1 << num)) != 0) {
            return false;
        }

        if ((matArr[r / 3][c / 3] & (1 << num)) != 0) {
            return false;
        }

        return true;
    }

    public static boolean isSafe(int[][] arr, int r, int c, int num) {
        if (arr.length != 9 || arr[0].length != 9 || arr[r][c] != 0) {
            return false;
        }

        for (int i = 0; i < 9; i++) {
            if (i == r)
                continue;
            if (arr[i][c] == num)
                return false;
        }

        for (int i = 0; i < 9; i++) {
            if (arr[r][i] == num)
                return false;
        }

        for (int i = 0; i < 9; i++) {
            if (arr[r][i] == num)
                return false;
        }

        int br = (r / 3) * 3; // get start row => (7 / 3) = 2 * 3 = 6 => start from 6th row and check 3 more
                              // rows
        int bc = (c / 3) * 3; // same for column

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[br + i][bc + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void solveSudoku(int[][] arr, int boxNo) {
        int r = boxNo / arr[0].length;
        int c = boxNo % arr[0].length;

        // There might be a case where last element is zero so we set a number for it and make a call forward.
        // This will make row number 9 and therefore all zeroes are set. We can print the ans now.
        // We can also replace this check with boxNo == 81  
        if (r == arr.length) {
            for(int[] row: arr) {
                for(int ele: row) {
                    System.out.print(ele + " ");
                }
                System.out.println();
            }
            return;
        }

        if (arr[r][c] != 0) {
            solveSudoku(arr, boxNo + 1);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (isSafeBetter(arr, r, c, i)) {
                arr[r][c] = i;

                rowArr[r] |= (1 << i);
                colArr[c] |= (1 << i);
                matArr[r / 3][c / 3] |= (1 << i);
                
                solveSudoku(arr, boxNo + 1);
                
                rowArr[r] &= ~(1 << i);
                colArr[c] &= ~(1 << i);
                matArr[r / 3][c / 3] &= ~(1 << i);

                arr[r][c] = 0;
            }
        }
    }

    public static void main(String[] args) {

        int[][] grid = { 
        { 3, 1, 6, 5, 7, 8, 4, 9, 2 }, 
        { 5, 2, 9, 1, 3, 4, 7, 6, 8 }, 
        { 4, 8, 7, 6, 2, 9, 5, 3, 1 }, 
        { 2, 6, 3, 0, 1, 5, 9, 8, 7 }, 
        { 9, 7, 4, 8, 6, 0, 1, 2, 5 }, 
        { 8, 5, 1, 7, 9, 2, 6, 4, 3 }, 
        { 1, 3, 8, 0, 4, 7, 2, 0, 6 }, 
        { 6, 9, 2, 3, 5, 1, 8, 7, 4 }, 
        { 7, 4, 5, 0, 8, 6, 3, 1, 0 } }; 

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                int num = grid[i][j];
                rowArr[i] |= (1 << num);
                colArr[j] |= (1 << num);
                matArr[i / 3][j / 3] |= (1 << num);
            }
        }
        
        solveSudoku(grid, 0);
    }
}
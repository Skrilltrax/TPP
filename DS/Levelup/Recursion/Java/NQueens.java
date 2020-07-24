public class NQueens {

    public static final int queens = 4;

    public static boolean[] rowArr = new boolean[queens];
    public static boolean[] colArr = new boolean[queens];
    public static boolean[] diagArr = new boolean[(2 * queens) - 1];
    public static boolean[] antiArr = new boolean[(2 * queens) - 1];

    public static void markInArray(int r, int c) {
        rowArr[r] = true;
        colArr[c] = true;
        diagArr[r - c + queens - 1] = true;
        antiArr[r + c] = true;
    }

    public static void unmarkInArray(int r, int c) {
        rowArr[r] = false;
        colArr[c] = false;
        diagArr[r - c + queens - 1] = false;
        antiArr[r + c] = false;
    }

    public static boolean isSafeArray(int r, int c) {
        return !rowArr[r] && !colArr[c] && !antiArr[r + c] && !diagArr[r - c + queens - 1]; 
    }


    public static void nQueensBetter(int r, int c, int qpsf, int totalQueens, String ans) {
        if (qpsf == totalQueens) {
            System.out.println(ans);
            return;
        }

        // i < totalQueens because totalQueens is always equal to no of columns
        for (int i = 0; i < totalQueens; i++) {
            if (isSafeArray(r, i)) {
                markInArray(r, i);
                nQueensBetter(r + 1, c, qpsf + 1, totalQueens, ans + "(" + r + ", " + i + ") ");
                unmarkInArray(r, i);
            }           
        }
    }

    public static int rowBit = 0;
    public static int colBit = 0;
    public static int diagBit = 0;
    public static int antiBit = 0;

    public static void markInBit(int r, int c) {
        rowBit |= (1 << r);
        colBit |= (1 << c);
        diagBit |= (1 << (r - c + queens - 1));
        antiBit |= (1 << (r + c - 1));
    }

    public static void unmarkInBit(int r, int c) {
        rowBit &= ~(1 << r);
        colBit &= ~(1 << c);
        diagBit &= ~(1 << (r - c + queens - 1));
        antiBit &= ~(1 << (r + c - 1));
    }

    public static boolean isSafeBit(int r, int c) {
        return ((rowBit & (1 << r)) == 0) && ((colBit & (1 << c)) == 0) && ((diagBit & (1 << (r - c + queens - 1))) == 0) && ((antiBit & (1 << (r + c - 1))) == 0); 
    }


    public static void nQueensBit(int r, int c, int qpsf, int totalQueens, String ans) {
        if (qpsf == totalQueens) {
            System.out.println(ans);
            return;
        }

        // i < totalQueens because totalQueens is always equal to no of columns
        for (int i = 0; i < totalQueens; i++) {
            if (isSafeBit(r, i)) {
                markInBit(r, i);
                nQueensBit(r + 1, c, qpsf + 1, totalQueens, ans + "(" + r + ", " + i + ") ");
                unmarkInBit(r, i);
            }           
        }
    }
    
    public static void main(String[] args) {
        nQueensBetter(0, 0, 0, queens, "");
    }
}
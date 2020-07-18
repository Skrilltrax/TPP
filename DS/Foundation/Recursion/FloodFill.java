import java.util.*;

public class FloodFill {

    public static void main(String[] args) throws Exception {
        // write your code here
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] mat = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            floodfill(mat, 0, 0, "");
            System.out.println();
        }
    }

    public static int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } }; // TLDR
    public static String[] s = { "t", "l", "d", "r " };

    public static boolean isSafe(int[][] maze, int row, int col) {
        if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length || maze[row][col] == 1) {
            return false;
        }
        return true;
    }

    public static void floodfill(int[][] maze, int row, int col, String psf) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(psf);
            return;
        }

        maze[row][col] = 1;

        for (int i = 0; i < dir.length; i++) {
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];

            if (isSafe(maze, nr, nc)) {
                floodfill(maze, nr, nc, psf + s[i]);
            }
        }
        maze[row][col] = 0;
    }
}
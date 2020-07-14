import java.util.*;

public class PrintStairPaths {

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            printStairPaths(n, "");
        }
    }

    public static void printStairPaths(int n, String path) {
        if (n <= 0) {
            if (n == 0) {
                System.out.println(path);
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            printStairPaths(n - i, path + i);
        }
    }

}
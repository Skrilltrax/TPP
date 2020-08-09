import java.io.*;
import java.util.*;

public class ArrangeBuildings {

    public static void main(String[] args) throws Exception {
        // write your code here
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();

            System.out.println(arrangeBuildings(n));
        }
    }

    public static long arrangeBuildings(int n) {
        long b = 1; // building
        long s = 1; // space

        for (int i = 2; i <= n; i++) {
            long temp = s;
            s = b + s;
            b = temp;
        }

        long osa = b + s; // one side ans

        return osa * osa;
    }

}
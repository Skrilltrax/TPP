import java.util.Scanner;

public class PrintPermutations {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            String str = sc.nextLine();
            printPerm(str, "");
        }
    }

    public static void printPerm(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String nstr = str.substring(0, i) + str.substring(i + 1);

            printPerm(nstr, ans + ch);
        }

    }
}
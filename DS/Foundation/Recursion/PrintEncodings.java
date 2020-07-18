import java.util.*;

public class PrintEncodings {

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            String str = sc.nextLine();
            printEncodings(str, "");
            System.out.println();
        }

    }

    public static void printEncodings(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        if (str.charAt(0) == '0') {
            return;
        }

        int n1 = str.charAt(0) - '0';
        n1--;
        printEncodings(str.substring(1), ans + (char) (n1 + 'a'));

        if (str.length() >= 2) {
            int n2 = ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0');
            n2--;
            if (n2 > 9 && n2 <= 25)
                printEncodings(str.substring(2), ans + (char) (n2 + 'a'));
        }
    }
}
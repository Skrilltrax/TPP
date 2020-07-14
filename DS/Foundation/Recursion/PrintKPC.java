import java.util.*;

public class PrintKPC {

    // 0 -> .;
    // 1 -> abc
    // 2 -> def
    // 3 -> ghi
    // 4 -> jkl
    // 5 -> mno
    // 6 -> pqrs
    // 7 -> tu
    // 8 -> vwx
    // 9 -> yz

    public static String[] keyboard = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            String str = sc.nextLine();
            printKPC(str, "");
        }
    }

    public static void printKPC(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        int num = str.charAt(0) - '0';
        String nums = keyboard[num];

        for (int i = 0; i < nums.length(); i++) {
            printKPC(str.substring(1), ans + nums.charAt(i) + "");
        }
    }

}
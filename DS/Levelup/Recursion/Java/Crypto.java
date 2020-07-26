import java.util.HashMap;

public class Crypto {

    public static String str1 = "send";
    public static String str2 = "more";
    public static String str3 = "money";
    public static boolean[] isTaken = new boolean[10];

    public static int convertStringToInteger(HashMap<Character, Integer> map, String str) {
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            ans = ans * 10 + map.getOrDefault(str.charAt(i), -1);
        }

        return ans;
    }

    public static void performRecursion(HashMap<Character, Integer> map, int idx, String distinctChars) {
        if (idx == distinctChars.length()) {
            if (convertStringToInteger(map, str1) + convertStringToInteger(map, str2) == convertStringToInteger(map,str3)) {
                System.out.println(map);
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!isTaken[i]) {
                Character key = distinctChars.charAt(idx);
                
                isTaken[i] = true;
                map.put(key, i);
                
                performRecursion(map, idx + 1, distinctChars);
                
                map.put(key, -1);
                isTaken[i] = false;
            }
        }
    }

    public static void solveCrypto() {
        String str = str1 + str2 + str3;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            Character key = str.charAt(i);
            if (!map.containsKey(key)) {
                map.put(key, -1);
            }
        }

        String distinct = "";
        
        for(int i = 0; i < map.keySet().toArray().length; i++) {
            distinct += map.keySet().toArray()[i];
        }

        System.out.println(distinct);

        performRecursion(map, 0, distinct);
    }


    public static void main(String[] args) {
        solveCrypto();
    }

}
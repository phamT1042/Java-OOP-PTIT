import java.util.LinkedHashMap;
import java.util.Scanner;

public class J03020 {
    static boolean check(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(r) != s.charAt(l)) return false;
            l++; r--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s;
        LinkedHashMap<String, Integer> save = new LinkedHashMap<>();
        int lengthMax = 0;

        while (scan.hasNext()) {
            s = scan.next();
            if (check(s)) {
                if (s.length() == lengthMax) {
                    if (save.containsKey(s)) save.replace(s, save.get(s) + 1);
                    else save.put(s, 1);
                }
                else if (s.length() > lengthMax) {
                    lengthMax = s.length();
                    save.clear();
                    save.put(s, 1);
                }
            }
        }

        for (String key : save.keySet()) System.out.printf("%s %d\n", key, save.get(key));

        scan.close();
    }
}
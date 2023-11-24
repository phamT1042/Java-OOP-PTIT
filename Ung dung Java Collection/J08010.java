import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class J08010 {
    private static boolean check(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(r) != s.charAt(l)) return false;
            l++; r--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> save = new ArrayList<>();
        HashMap<String, Integer> cnt = new HashMap<>();
        int mxLength = 0;

        while (sc.hasNext()) {
            String s = sc.next();
            if (check(s)) {
                if (cnt.containsKey(s)) {
                    int val = cnt.get(s) + 1;
                    cnt.put(s, val);
                    
                    if (s.length() > mxLength) mxLength = s.length();
                }
                else {
                    cnt.put(s, 1);
                    save.add(s);
                }
            }
        }

        for (String x : save)
            if (x.length() == mxLength) System.out.println(x + " " + cnt.get(x));

        sc.close();
    }
}

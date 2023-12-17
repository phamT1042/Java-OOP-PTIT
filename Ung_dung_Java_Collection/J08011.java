import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class J08011 {
    private static boolean check (String s) {
        for (int i = 1; i < s.length(); ++i) 
            if (s.charAt(i) < s.charAt(i - 1)) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> save = new ArrayList<>();
        HashMap<String, Integer> cnt = new HashMap<>();
        while (sc.hasNext()) {
            String s = sc.next();
            if (check(s)) {
                if (cnt.containsKey(s)) 
                    cnt.put(s, cnt.get(s) + 1);
                else {
                    save.add(s);
                    cnt.put(s, 1);
                }
            }
        }

        save.sort(Comparator.comparingInt(e -> cnt.get(e)).reversed());
        for (String x : save)
            System.out.println(x + " " + cnt.get(x));

        sc.close();
    }
    
}

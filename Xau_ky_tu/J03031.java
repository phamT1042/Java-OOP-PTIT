import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class J03031 {
    private static String check (String s, int k) {
        if (s.length() < 26) return "NO";
        Set<Character> cnt = new HashSet<>();
        for (int i = 0; i < s.length(); ++i) cnt.add(s.charAt(i));

        return (cnt.size() + k >= 26 && s.length() >= 26 - cnt.size() ? "YES" : "NO");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();

            System.out.println(check(s, k));
        }

        sc.close();
    }
}

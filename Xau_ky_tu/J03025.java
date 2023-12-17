import java.util.Scanner;

public class J03025 {
    private static String check (String s) {
        int l = 0, r = s.length() - 1;
        boolean flag = false;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                if (flag) return "NO";
                else flag = true;
            }
            l++; r--;
        }
        return (flag || (s.length() % 2 == 1) ? "YES" : "NO");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            System.out.println(check(s));
        }

        sc.close();
    }
}

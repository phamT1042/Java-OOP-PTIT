import java.util.Scanner;

public class a {
    static char prime[] = {'2', '3', '5', '7'};
    static String check(String s) {
        int l = 0, r = s.length() - 1;
            while (l <= r) {
                if (s.charAt(l) == s.charAt(r)) {
                    int val = s.charAt(l) - '0';
                    if (val != 2 && val != 3 && val != 5 && val != 7) return "NO";
                }
                else return "NO";
                l++; r--;
            }
        return "YES";
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            String s = scan.next();
            System.out.println(check(s));
        }
        
        scan.close();
    }
}
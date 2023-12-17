import java.util.Scanner;

public class J03035 {
    private static String a, b;
    
    private static long choose(int i) {
        long cnt = 1;
        for (int j = i; j < a.length(); ++j) {
            if (a.charAt(j) == '?') cnt *= 10;
        }
        return cnt;
    }
    
    private static long solve () {
        long res = 0;
        int n = a.length();
        
        for (int i = 0; i < n; ++i) {
            char ai = a.charAt(i);
            char bi = b.charAt(i);
            if (ai == '?') {
                int mn = 10 - (bi - '0' + 1);
                res += mn * choose(i + 1);
            }
            else {
                if (ai > bi) {
                    return res + choose(i + 1);
                }
                else if (ai < bi) return res;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) {
            a = sc.next();
            b = sc.next();
            System.out.println(solve());
        }
        
        sc.close();
    }
    
}
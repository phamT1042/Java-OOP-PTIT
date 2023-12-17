import java.util.Scanner;

public class J03026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) {
            String s1 = sc.next();
            String s2 = sc.next();
            int res = -1;
            
            for (int i = 0; i < s1.length(); ++i)
                for (int j = i; j < s1.length(); ++j) {
                    String tmp = s1.substring(i, j + 1);
                    if (!s2.contains(tmp)) res = Math.max(res, j - i + 1);
                }
            
            for (int i = 0; i < s2.length(); ++i)
                for (int j = i; j < s2.length(); ++j) {
                    String tmp = s2.substring(i, j + 1);
                    if (!s1.contains(tmp)) res = Math.max(res, j - i + 1);
                }
            
            System.out.println(res);
        }
        
        sc.close();
    }
    
}
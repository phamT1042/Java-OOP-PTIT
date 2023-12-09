import java.util.Scanner;

public class J03027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();
        boolean check = true;
        int n = s.length();
        while (check) {
            check = false;
            int i;
            for (i = 0; i < n - 1; ++i) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    check = true;
                    break;
                }
            }  
            
            if (check) s = s.substring(0, i) + s.substring(i + 2);
            n -= 2;
            if (n == 0) break;
        }
        
        if (n == 0) System.out.println("Empty String");
        else System.out.println(s);
        
        sc.close();
    }
    
}

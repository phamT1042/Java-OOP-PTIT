import java.util.HashMap;
import java.util.Scanner;

public class J03023 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashMap<Character, Integer> save = new HashMap<>();
        save.put('I', 1);
        save.put('V', 5);
        save.put('X', 10);
        save.put('L', 50);
        save.put('C', 100);
        save.put('D', 500);
        save.put('M', 1000);

        int t = scan.nextInt();
        while (t-- > 0) {
            String s = scan.next();
            int n = s.length();
            int res = save.get(s.charAt(n - 1));

            for (int i = n - 2; i >= 0; i--) {
                int before = save.get(s.charAt(i)), after = save.get(s.charAt(i + 1));
                if (before < after) res -= before;
                else res += before; 
            }

            System.out.println(res);
        }

        scan.close();
    }
}
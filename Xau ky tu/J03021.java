import java.util.HashMap;
import java.util.Scanner;

public class J03021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Character, Integer> chr = new HashMap<>();
        int val = 2;
        for (int i = 0; i < 26; ++i) {
            char x = (char) (i + 'A');
            if (i == 3 || i == 6 || i == 9 || i == 12 || i == 15 || i == 19 || i == 22) val++;
            chr.put(x, val);
        }
 
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next().toUpperCase();
            int l = 0, r = s.length() - 1;
            String res = "YES";
            while (l < r) {
                if (chr.get(s.charAt(l)) != chr.get(s.charAt(r))) {
                    res = "NO";
                    break;
                }
                l++; r--;
            }
            System.out.println(res);
        }
        sc.close();
    }
}
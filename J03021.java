import java.util.HashMap;
import java.util.Scanner;

public class J03021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> block = new HashMap<>();
        block.put("ABC", 2);
        block.put("DEF", 3);
        block.put("GHI", 4);
        block.put("JKL", 5);
        block.put("MNO", 6);
        block.put("PQRS", 7);
        block.put("TUV", 8);
        block.put("WXYZ", 9);
        HashMap<Character, Integer> chr = new HashMap<>();
        for (String x : block.keySet()) 
            for (int i = 0; i < x.length(); ++i) 
                chr.put(x.charAt(i), block.get(x));
 
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
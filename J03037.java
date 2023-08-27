import java.util.HashMap;
import java.util.Scanner;

public class J03037 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        HashMap<Character, Integer> first = new HashMap<>();
        HashMap<Character, Integer> second = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (first.containsKey(x)) second.put(x, i);
            else first.put(x, i);
        }

        int res = 0;
        for (char i = 'A'; i <= 'Z'; i++) {
            for (char j = 'A'; j <= 'Z'; j++) {
                if (i == j) continue;
                if (first.get(i) < first.get(j) && first.get(j) < second.get(i) && second.get(i) < second.get(j)) 
                    res++;
            }
        }
        System.out.println(res);

        scan.close();
    }
}
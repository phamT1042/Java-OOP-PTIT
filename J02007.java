import java.util.Scanner;
import java.util.TreeMap;

public class J02007 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int t = scan.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scan.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<>();

            while (n-- > 0) {
                int x = scan.nextInt();
                if (map.containsKey(x)) 
                    map.replace(x, map.get(x) + 1);
                else map.put(x, 1);
            }

            System.out.printf("Test %d:\n", i);
            
        }
        scan.close();
    }
}

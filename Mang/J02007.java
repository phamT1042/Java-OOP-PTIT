import java.util.Scanner;
import java.util.LinkedHashMap;

public class J02007 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int t = scan.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scan.nextInt();
            LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

            while (n-- > 0) {
                int x = scan.nextInt();
                if (map.containsKey(x)) 
                    map.replace(x, map.get(x) + 1);
                else map.put(x, 1);
            }

            System.out.printf("Test %d:\n", i);
            for (Integer x : map.keySet()) {
                System.out.printf("%d xuat hien %d lan\n", x, map.get(x));
            }
        }
        scan.close();
    }
}

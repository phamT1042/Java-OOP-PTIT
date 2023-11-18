import java.util.Scanner;
import java.util.TreeMap;

public class J02009 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        TreeMap<Integer, Integer> time = new TreeMap<>();
        while (n-- > 0) {
            int t = scan.nextInt();
            int d = scan.nextInt();
            if (time.containsKey(t)) time.replace(t, time.get(t) + d);
            else time.put(t, d);
        }

        long end = 0;
        for (Integer key : time.keySet()) {
            if (end == 0) end = key + time.get(key);
            else {
                if (key > end) end = key + time.get(key);
                else end += time.get(key);
            }
        }
        System.out.println(end);
        
        scan.close();
    }
}
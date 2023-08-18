import java.util.Scanner;
import java.util.TreeSet;

public class J02006 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int m = scan.nextInt();
        TreeSet<Integer> set1 = new TreeSet<>();

        while (n-- > 0) {
            int x = scan.nextInt();
            set1.add(x);
        }
        while (m-- > 0) {
            int x = scan.nextInt();
            set1.add(x);
        }

        for (int x : set1) System.out.print(x + " ");
        
        scan.close();
    }
}

import java.util.Scanner;
import java.util.TreeSet;

public class J02005 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int m = scan.nextInt();
        TreeSet<Integer> set1 = new TreeSet<>();
        TreeSet<Integer> set2 = new TreeSet<>();

        while (n-- > 0) {
            int x = scan.nextInt();
            set1.add(x);
        }
        while (m-- > 0) {
            int x = scan.nextInt();
            set2.add(x);
        }

        set1.retainAll(set2);
        for (int x : set1) System.out.print(x + " ");
        
        scan.close();
    }
}

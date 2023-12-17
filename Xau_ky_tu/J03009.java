import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class J03009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            TreeSet<String> S1 = new TreeSet<>(Arrays.asList(s1.split(" "))); 
            TreeSet<String> S2 = new TreeSet<>(Arrays.asList(s2.split(" ")));
            S1.removeAll(S2);
            for (String x : S1) System.out.printf("%s ", x);
            System.out.println();
        }

        sc.close();
    }
}

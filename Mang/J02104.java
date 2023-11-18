import java.util.ArrayList;
import java.util.Scanner;

public class J02104 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        ArrayList<String> dsCanh = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                byte x = scan.nextByte();
                if (x == 1 && j > i) dsCanh.add("(" + i + "," + j + ")"); 
            }
        }
        for (String x : dsCanh)
            System.out.println(x);

        scan.close();
    }
}
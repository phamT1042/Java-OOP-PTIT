import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class J07002 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        FileReader f = new FileReader("DATA.in");
        try (BufferedReader read = new BufferedReader(f)) {
            String s;
            long sum = 0;
            while ((s = read.readLine()) != null) {
                String tach[] = s.split(" ");
                for (String x : tach) {
                    int a;
                    try {
                        a = Integer.parseInt(x);
                    } catch (NumberFormatException e) {
                        continue;
                    }
                    sum += a;
                }
            }
            System.out.println(sum);
        }
        
        sc.close();
    }
}
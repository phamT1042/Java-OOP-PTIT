import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class J07008 {
    private static int a[];
    private static byte sh[];
    private static int n;
    private static ArrayList<String> res;
    
    private static void checkAdd() {
        int first = 0, bits = 0;
        String tmp = "";
        for (int i = 0; i < n; ++i) {
            if (sh[i] == 1) {
                if (a[i] > first) {
                    first = a[i];
                    tmp += String.valueOf(a[i]) + " ";
                    bits++;
                }
                else return;
            }
        }
        if (bits > 1) res.add(tmp);
    }
    
    private static void Try (int i) {
        for (byte j = 0; j <= 1; ++j) {
            sh[i] = j;
            if (i == n - 1) checkAdd();
            else Try(i + 1);
         }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DAYSO.in"));
        
        n = Integer.parseInt(sc.nextLine());
        a = new int[n];
        sh = new byte[n];
        res = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            a[i] = Integer.parseInt(sc.next());
        
        Try(0);
        Collections.sort(res);
        for (String x : res) System.out.println(x);
       
        sc.close();
    }
    
}
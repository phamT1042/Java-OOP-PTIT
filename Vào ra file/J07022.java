import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class J07022 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner (new File("DATA.in"));

        ArrayList<String> res = new ArrayList<>();
        while (sc.hasNext()) {
            String s = sc.next();
            try {
                int a = Integer.parseInt(s);               
            } catch (Exception e) {
                res.add(s);
            }
        }
        Collections.sort(res);
        for (String x : res) System.out.printf("%s ", x);

        sc.close();
    }
}
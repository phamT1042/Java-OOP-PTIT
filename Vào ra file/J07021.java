import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class J07021 {
    public static String chuanHoa(String s) {
        String[] tach = s.split("\\s+");
        String res = "";
        for (String x : tach) {
            x = x.toLowerCase();
            res += Character.toUpperCase(x.charAt(0)) + x.substring(1) + " ";
        }
        return res.trim();
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));

        ArrayList<String> res = new ArrayList<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine().trim();
            if (s.equals("END")) break;
            res.add(chuanHoa(s));
        }

        for (String x : res) System.out.println(x);

        sc.close();
    }
}
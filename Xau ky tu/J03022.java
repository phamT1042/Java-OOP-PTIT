import java.util.ArrayList;
import java.util.Scanner;

public class J03022 {
    private static String title(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        ArrayList<String> res = new ArrayList<>();
        byte start = 1, end = 0;
        String sentence = "";
        while (sc.hasNextLine()) {
            String data[] = sc.nextLine().trim().split("\\s+");
            for (String x : data) {
                if (x.endsWith(".") || x.endsWith("?") || x.endsWith("!")) end = 1;
                if (start == 1) {
                    if (end == 1) {
                        String tmp = title(x);
                        sentence += tmp.substring(0, tmp.length() - 1) + " ";
                        res.add(sentence);
                        sentence = "";
                        end = 0;
                    }
                    else {
                        sentence += title(x) + " ";
                        start = 0;
                    }
                }
                else {
                    if (end == 1) {
                        sentence += x.toLowerCase().substring(0, x.length() - 1) + " ";
                        res.add(sentence);
                        sentence = "";
                        end = 0;
                        start = 1;
                    }
                    else {
                        sentence += x.toLowerCase() + " ";
                    }
                }
            }
        }
        
        for (String x : res) System.out.println(x);
        
        sc.close();
    }
    
}

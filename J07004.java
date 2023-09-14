import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeMap;
import java.io.FileNotFoundException;
import java.io.IOException;

public class J07004 {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        try {
            FileReader f = new FileReader("DATA.in");
            BufferedReader doc = new BufferedReader(f);

            String s;
            try {
                while ((s = doc.readLine()) != null) {
                    int number;
                    for (String x : s.split(" ")) {
                        number = Integer.parseInt(x);
                        if (cnt.containsKey(number)) cnt.replace(number, cnt.get(number) + 1);
                        else cnt.put(number, 1);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        for (Integer key : cnt.keySet()) 
            System.out.printf("%d %d\n", key, cnt.get(key));
    }
    


}

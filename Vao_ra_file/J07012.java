import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class J07012 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream inp = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> a = (ArrayList<String>) inp.readObject();

        HashMap<String, Integer> cnt = new HashMap<>();

        for (String x : a) {
            String[] tach = x.toLowerCase().split("[^a-z0-9]+");
            for (String y : tach) {
                if (y.isEmpty()) continue;
                if (cnt.containsKey(y))
                    cnt.put(y, cnt.get(y) + 1);
                else 
                    cnt.put(y, 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(cnt.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {    
            public int compare(Map.Entry<String, Integer> chr1, Map.Entry<String, Integer> chr2) {
                if (chr2.getValue().equals(chr1.getValue()))   
                    return chr1.getKey().compareTo(chr2.getKey());
                return chr2.getValue().compareTo(chr1.getValue());
        }});

        list.forEach((chr)->System.out.println(chr.getKey() + " " + chr.getValue()));
    }
}

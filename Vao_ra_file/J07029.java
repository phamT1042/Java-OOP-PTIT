import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class J07029 {
    private static int sang[] = new int[1000001];
    private static void sangNT() {
        sang[0] = sang[1] = 1;
        for (int i = 2; i * i < 1000001; ++i)
            if (sang[i] == 0)
                for (int j = i * i; j < 1000001; j += i) sang[j] = 1;
    } 
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        ObjectInputStream inp = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Integer> a = (ArrayList<Integer>) inp.readObject();
        inp.close();

        sangNT();
        TreeMap<Integer, Integer> cnt = new TreeMap<>(Collections.reverseOrder());

        for (Integer x : a) {
            if (sang[x] == 0) {
                if (cnt.containsKey(x)) 
                    cnt.put(x, cnt.get(x) + 1);
                else 
                    cnt.put(x, 1);
            }
        }

        int res = 0;
        for (Integer x : cnt.keySet()) {
            System.out.println(x + " " + cnt.get(x));
            res++;
            if (res == 10) break;
        }
    }
}

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class J07023 {
    private static int sang[] = new int[10001];
    private static void sangNT() {
        sang[0] = sang[1] = 1;
        for (int i = 2; i * i < 10001; ++i)
            if (sang[i] == 0)
                for (int j = i * i; j < 10001; j += i) sang[j] = 1;
    }

    private static boolean thuanNghich(int x) {
        String s = String.valueOf(x);
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream inp = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<Integer> d1 = (ArrayList<Integer>) inp.readObject();
        inp.close();
        inp = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> d2 = (ArrayList<Integer>) inp.readObject();
        inp.close();

        sangNT();
        HashMap<Integer, Integer> cnt1 = new HashMap<>();
        TreeMap<Integer, Integer> cnt2 = new TreeMap<>();

        for (Integer x : d1) {
            if (sang[x] == 0 && thuanNghich(x)) {
                if (cnt1.containsKey(x)) 
                    cnt1.put(x, cnt1.get(x) + 1);
                else 
                    cnt1.put(x, 1);
            }
        }

        for (Integer x : d2) {
            if (cnt1.containsKey(x)) {
                if (cnt2.containsKey(x)) 
                    cnt2.put(x, cnt2.get(x) + 1);
                else
                    cnt2.put(x, 1);
            }
        }

        for (Integer x : cnt2.keySet()) 
            System.out.println(x + " " + cnt1.get(x) + " " + cnt2.get(x));
    }
}

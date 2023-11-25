import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.TreeMap;

public class J07032 {
    private static boolean check (int x) {
        String s = String.valueOf(x);
        int l = 0, r = s.length() - 1;
        if ((r + 1) % 2 == 0 || r == 0) return false;

        while (l <= r) {
            if (s.charAt(l) != s.charAt(r) || (s.charAt(l) % 2 == 0) || (s.charAt(r) % 2 == 0)) return false;
            l++; r--;
        }
        return true;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream inp = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<Integer> a1 = (ArrayList<Integer>) inp.readObject();
        inp.close();
        inp = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> a2 = (ArrayList<Integer>) inp.readObject();
        inp.close();

        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        for (Integer x : a1) {
            if (check(x) && a2.contains(x)) {
                if (cnt.containsKey(x)) 
                    cnt.put(x, cnt.get(x) + 1);
                else 
                    cnt.put(x, 1);
            }
        }

        for (Integer x : a2) 
            if (cnt.containsKey(x)) cnt.put(x, cnt.get(x) + 1);

        int res = 0;
        for (Integer key : cnt.keySet()) {
            System.out.println(key + " " + cnt.get(key));
            res++;
            if (res == 10) break;
        }
        
    }
}

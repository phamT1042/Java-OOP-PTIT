import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class J07031 {
    private static int sang[] = new int[1000001];
    private static void sangNT() {
        sang[0] = sang[1] = 1;
        for (int i = 2; i * i < 1000001; ++i)
            if (sang[i] == 0)
                for (int j = i * i; j < 1000001; j += i) sang[j] = 1;
    } 
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        ObjectInputStream inp = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ArrayList<Integer> a1 = (ArrayList<Integer>) inp.readObject();
        inp.close();
        inp = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> a2 = (ArrayList<Integer>) inp.readObject();
        inp.close();

        sangNT();
        TreeSet<Integer> A1 = new TreeSet<>(a1);
        HashSet<Integer> A2 = new HashSet<>(a2);
        HashSet<Integer> check = new HashSet<>();

        for (Integer x : A1) {
            if (x >= 500000) break;
            if (check.contains(1000000 - x)) break;

            if (sang[x] == 0 && sang[1000000 - x] == 0) 
                if (A1.contains(1000000 - x) && !A2.contains(x) && !A2.contains(1000000 - x))  {
                    System.out.println(x + " " + (1000000 - x));
                    check.add(x);
                } 
        }
    }
}

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class J07015 {
    public static boolean prime(int x) {
        if (x < 2) return false;
        for (int i = 2; i <= Math.sqrt(x); i++)
            if (x % i == 0) return false;
        return true;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream inp = new ObjectInputStream(new FileInputStream("SONGUYEN.in"));
        ArrayList<Integer> a = (ArrayList<Integer>) inp.readObject();
        int cnt[] = new int[10000];

        for (Integer x : a) 
            if (prime(x)) cnt[x]++;
        
        for (int i = 0; i < 10000; i++) 
            if (cnt[i] > 0) System.out.printf("%d %d\n", i, cnt[i]);
    
        inp.close();
    }
    
}

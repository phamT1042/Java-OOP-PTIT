import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Pair implements Comparable<Pair> {
    private String xau;
    private int cnt;
    
    public Pair(String xau, int cnt) {
        this.xau = xau;
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return xau + " " + cnt;
    }

    @Override
    public int compareTo(Pair o) {
        if (o.cnt != this.cnt) return o.cnt - this.cnt;
        return this.xau.compareTo(o.xau);
    }
    
}

public class J07011 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("VANBAN.in"));

        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] a = sc.nextLine().toLowerCase().split("[^a-z0-9]+");
            for (String x : a)
                if (!x.isEmpty()) cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }

        ArrayList<Pair> res = new ArrayList<>();
        for (String x : cnt.keySet()) 
            res.add(new Pair(x, cnt.get(x)));
        
        Collections.sort(res);
        for (Pair x : res) System.out.println(x);

        sc.close();
    }
}
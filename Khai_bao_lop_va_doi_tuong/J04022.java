import java.util.Scanner;
import java.util.TreeSet;

class WordSet {
    private TreeSet<String> ds;

    public WordSet() {
        this.ds = new TreeSet<>();
    }

    public WordSet(String s) {
        this.ds = new TreeSet<>();
        if (s != "") for (String x : s.split("\\s+")) this.ds.add(x.toLowerCase());
    }

    @Override
    public String toString() {
        String res = "";
        for (String x : this.ds) res += x + " ";
        return res;
    }

    public WordSet union(WordSet other) {
        WordSet res = new WordSet();
        res.ds.addAll(this.ds);
        res.ds.addAll(other.ds);
        return res;
    }
    
    public WordSet intersection(WordSet other) {
        WordSet res = new WordSet();
        res.ds.addAll(this.ds);
        res.ds.retainAll(other.ds);
        return res;
    }
}

public class J04022 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

class WordSet {
    TreeSet<String> save;

    public WordSet() {
        save = new TreeSet<>();
    }

    public WordSet(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        save = new TreeSet<>();

        while (sc.hasNext()) save.add(sc.next().toLowerCase());
        sc.close();
    }

    public WordSet union(WordSet o) {
        WordSet res = new WordSet();
        res.save = (TreeSet<String>) this.save.clone();
        res.save.addAll(o.save);
        return res;
    } 

    public WordSet intersection(WordSet o) {
        WordSet res = new WordSet();
        res.save = (TreeSet<String>) this.save.clone();
        res.save.retainAll(o.save);
        return res;
    }

    @Override
    public String toString() {
        String res = "";
        for (String x : save) res += x + " ";
        return res;
    }
}

public class J07014 {
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}

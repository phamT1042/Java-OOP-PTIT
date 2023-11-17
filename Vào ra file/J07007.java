import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

class WordSet {
    private TreeSet<String> vb;

    public WordSet(String nameFile) throws FileNotFoundException {
        vb = new TreeSet<>();
        Scanner sc = new Scanner(new File(nameFile));
        while (sc.hasNext()) 
            this.vb.add(sc.next().toLowerCase());
    }

    @Override
    public String toString() {
        String res = "";
        for (String x : this.vb) res += x + "\n";
        return res;
    }
}

public class J07007 {
    public static void main(String[] args) throws IOException {
        WordSet ws = new WordSet("VANBAN.in");
        System.out.println(ws);
    }

}

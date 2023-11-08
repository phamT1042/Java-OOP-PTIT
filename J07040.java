import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class J07040 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream inp1 = new ObjectInputStream(new FileInputStream("NHIPHAN.in"));
        Scanner sc = new Scanner(new File("VANBAN.in"));

        ArrayList<String> tu = (ArrayList<String>) inp1.readObject();
        HashSet<String> saveTu = new HashSet<>();
        for (String x : tu) {
            String tach[] = x.trim().toLowerCase().split("\\s+");
            saveTu.addAll(Arrays.asList(tach));
        }

        ArrayList<String> saveTuTrongVB = new ArrayList<>();
        while (sc.hasNextLine()) {
            String x = sc.nextLine().trim().toLowerCase();
            saveTuTrongVB.addAll(Arrays.asList(x.split("\\s+")));
        }

        for (String x : saveTuTrongVB) {
            if (saveTu.contains(x)) {
                System.out.println(x);
                saveTu.remove(x);
            }
        }

        inp1.close();
        sc.close();
    }
}
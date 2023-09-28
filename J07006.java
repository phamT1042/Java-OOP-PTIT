import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.TreeMap;

public class J07006 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream input = new FileInputStream(new File("DATA.in"));

        ObjectInputStream read = new ObjectInputStream(input);

        ArrayList<Integer> list = (ArrayList<Integer>) read.readObject();
        read.close();
        input.close();

        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        for (Integer number : list) {
            if (cnt.containsKey(number)) cnt.replace(number, cnt.get(number) + 1);
            else cnt.put(number, 1);
        }
        for (Integer number : cnt.keySet()) 
            System.out.printf("%d %d\n", number, cnt.get(number));
    }
}
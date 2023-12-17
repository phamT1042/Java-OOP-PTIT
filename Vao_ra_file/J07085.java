import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class J07085 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream inp = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> a = (ArrayList<String>) inp.readObject();
        inp.close();

        for (String x : a) {
            String res = ""; 
            int sum = 0;
            for (int i = 0; i < x.length(); ++i) {
                char chr = x.charAt(i);
                if (chr >= '0' && chr <= '9') {
                    res += chr;
                    sum += chr - '0';
                }
            }
            if (sum > 0) {
                int i = 0;
                while (res.charAt(i) == '0') i++;
                System.out.println(res.substring(i) + " " + sum);
            }
        }
    }
}
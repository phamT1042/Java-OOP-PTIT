import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
public class HELLOFILE  {
    public static void main(String[] args) {
        FileReader fp;
        try {
            fp = new FileReader("Hello.txt");
            try {
                BufferedReader read = new BufferedReader(fp);
                String a;
                while ((a = read.readLine()) != null) 
                    System.out.println(a);
                fp.close();
                read.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
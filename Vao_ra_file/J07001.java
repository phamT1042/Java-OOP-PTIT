import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class J07001 {
    public static void main(String[] args) {
        FileReader file;
        try {
            file = new FileReader("DATA.in");
            BufferedReader read = new BufferedReader(file);
            String line;
            try {
                while ((line = read.readLine()) != null) 
                    System.out.println(line);

                file.close();
                read.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

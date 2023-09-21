import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class J07005 {
    public static void main(String[] args) throws IOException {
        DataInputStream input = new DataInputStream(new FileInputStream("DATA.in"));
        int a[] = new int[1000];

        for (int i = 0; i < 100000; i++) 
            a[input.readInt()]++;
        
        for (int i = 0; i < 1000; i++) 
            if (a[i] > 0) System.out.printf("%d %d\n", i, a[i]);

        input.close();
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class DoiTuong implements Comparable<DoiTuong> {
    private String ho, ten, tenDem;

    public DoiTuong(String hoVaten) {        
        String[] tach = hoVaten.trim().split("\\s+");
        this.ho = this.ten = this.tenDem = "";
        
        for (int i = 0; i < tach.length; ++i) {
            String tu = tach[i].substring(0, 1).toUpperCase() + tach[i].substring(1).toLowerCase();            
            if (i == 0) this.ho = tu;
            else if (i == tach.length - 1) this.ten = tu;
            else this.tenDem += tu + " ";
        }
    }

    @Override
    public int compareTo(DoiTuong o) {
        if (this.ten.equals(o.ten)) {
            if (this.ho.equals(o.ho)) return this.tenDem.compareTo(o.tenDem);
            return this.ho.compareTo(o.ho);
        }
        return this.ten.compareTo(o.ten);
    }

    @Override
    public String toString() {
        return ho + " " + tenDem + ten;
    }
}

public class J07072 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        
        ArrayList<DoiTuong> a = new ArrayList<>();
        while (sc.hasNextLine())
            a.add(new DoiTuong(sc.nextLine()));
        
        Collections.sort(a);
        for (DoiTuong x : a) System.out.println(x);
               
        sc.close();
    }
}
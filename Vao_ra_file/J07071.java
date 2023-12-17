import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class DoiTuong implements Comparable<DoiTuong> {
    private String hoVaten, vietTat;
    private String ho, ten;

    public DoiTuong(String hoVaten) {
        this.vietTat = "";
        this.hoVaten = chuanHoa(hoVaten);
    }

    private String chuanHoa(String s) {
        String[] tach = s.trim().split("\\s+");
        String res = "";
        
        for (int i = 0; i < tach.length; ++i) {
            String tu = tach[i].substring(0, 1).toUpperCase() + tach[i].substring(1).toLowerCase();            
            res += tu + " ";
            this.vietTat += tach[i].substring(0, 1).toUpperCase() + '.';
            if (i == 0) this.ho = tu;
            else if (i == tach.length - 1) this.ten = tu;
        }

        this.vietTat = this.vietTat.substring(0, this.vietTat.length() - 1);
        return res.trim();
    }

    public boolean check (String s) {
        if (s.length() != this.vietTat.length()) return false;
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != this.vietTat.charAt(i)) cnt++;
            if (cnt > 1) return false;
        }
        return true;
    }

    @Override
    public int compareTo(DoiTuong o) {
        if (this.ten.equals(o.ten)) return this.ho.compareTo(o.ho);
        return this.ten.compareTo(o.ten);
    }

    @Override
    public String toString() {
        return hoVaten;
    }
}

public class J07071 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        
        int n = Integer.parseInt(sc.nextLine());
        DoiTuong a[] = new DoiTuong[n];
        for (int i = 0; i < n; ++i)
            a[i] = new DoiTuong(sc.nextLine());
        Arrays.sort(a);
        
        int m = Integer.parseInt(sc.nextLine());
        while (m-- > 0) {
            String tk = sc.nextLine();
            for (DoiTuong x : a) 
                if (x.check(tk)) System.out.println(x);
        }
        
        sc.close();
    }
}
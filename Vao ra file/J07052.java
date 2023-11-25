import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class ThiSinh implements Comparable<ThiSinh> {
    private String maTS, ten;
    private float toan, ly, hoa, uuTien;
    private float tongDiem;

    public ThiSinh(String maTS, String ten, float toan, float ly, float hoa) {
        this.maTS = maTS;
        this.ten = chuanHoa(ten);
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;

        if (this.maTS.charAt(2) == '1') this.uuTien = 0.5f;
        else if (this.maTS.charAt(2) == '2') this.uuTien = 1;
        else this.uuTien = 2.5f;
        
        this.tongDiem = this.toan * 2 + this.ly + this.hoa + this.uuTien;
    }

    private String chuanHoa(String s) {
        String[] tach = s.trim().split("\\s+");
        String res = "";
        
        for (String x : tach) 
            res += x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase() + " ";

        return res.trim();
    }

    @Override
    public int compareTo(ThiSinh o) {
        return o.tongDiem > this.tongDiem ? 1 : -1;
    }

    @Override
    public String toString() {
        return maTS + " " + ten + " " + (uuTien == 1 ? "1" : uuTien) + " " + String.format("%.1f ", tongDiem);
    }

    public float getTongDiem() {
        return tongDiem;
    }
}

public class J07052 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Phong.txt"));
        
        int n = Integer.parseInt(sc.nextLine());
        ThiSinh a[] = new ThiSinh[n];
        for (int i = 0; i < n; ++i)
            a[i] = new ThiSinh(sc.nextLine(), sc.nextLine(), Float.parseFloat(sc.nextLine()), Float.parseFloat(sc.nextLine()), Float.parseFloat(sc.nextLine()));
        int chiTieu = Integer.parseInt(sc.nextLine());

        Arrays.sort(a);
        float diemChuan = (chiTieu >= n ? a[n - 1].getTongDiem() : a[chiTieu - 1].getTongDiem());

        System.out.println(String.format("%.1f", diemChuan));
        for (int i = 0; i < n; ++i) 
            System.out.println(a[i] + (a[i].getTongDiem() == diemChuan ? "TRUNG TUYEN" : "TRUOT"));
        
        sc.close();
    }
}

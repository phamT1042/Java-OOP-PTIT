import java.util.Arrays;
import java.util.Scanner;

class ThiSinh implements Comparable<ThiSinh> {
    private String maTS, ten;
    private float toan, ly, hoa, uuTien;
    private float tongDiem;

    public ThiSinh(String maTS, String ten, float toan, float ly, float hoa) {
        this.maTS = maTS;
        this.ten = ten;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;

        if (this.maTS.charAt(2) == '1') this.uuTien = 0.5f;
        else if (this.maTS.charAt(2) == '2') this.uuTien = 1;
        else this.uuTien = 2.5f;
        
        this.tongDiem = this.toan * 2 + this.ly + this.hoa + this.uuTien;
    }

    @Override
    public int compareTo(ThiSinh o) {
        if (o.tongDiem == this.tongDiem) return this.maTS.compareTo(o.maTS);
        return o.tongDiem > this.tongDiem ? 1 : -1;
    }

    @Override
    public String toString() {
        return maTS + " " + ten + " " + (uuTien == 1 ? "1" : uuTien) + " " + (tongDiem == (int)tongDiem ? (int)tongDiem : String.format("%.1f ", tongDiem));
    }

    public float getTongDiem() {
        return tongDiem;
    }
}

public class J05059 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        ThiSinh a[] = new ThiSinh[n];
        for (int i = 0; i < n; ++i)
            a[i] = new ThiSinh(sc.nextLine(), sc.nextLine(), Float.parseFloat(sc.nextLine()), Float.parseFloat(sc.nextLine()), Float.parseFloat(sc.nextLine()));
        int chiTieu = Integer.parseInt(sc.nextLine());

        Arrays.sort(a);
        float diemChuan = (chiTieu >= n ? a[n - 1].getTongDiem() : a[chiTieu - 1].getTongDiem());

        System.out.println(String.format("%.1f", diemChuan));
        for (int i = 0; i < n; ++i) 
            System.out.println(a[i] + " " + (a[i].getTongDiem() >= diemChuan ? "TRUNG TUYEN" : "TRUOT"));
        
        sc.close();
    }
}

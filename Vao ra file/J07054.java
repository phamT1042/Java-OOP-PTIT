import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class SinhVien implements Comparable<SinhVien> {
    private String maSV, ten;
    private float diem1, diem2, diem3;
    private float diemTB;


    public SinhVien(int maSV, String ten, float diem1, float diem2, float diem3) {
        this.maSV = String.format("SV%02d", maSV);
        this.ten = chuanHoa(ten);
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;

        this.diemTB = (diem1 * 3 + diem2 * 3 + diem3 * 2) / 8;
    }

    private String chuanHoa(String s) {
        String[] tach = s.trim().split("\\s+");
        String res = "";
        
        for (String x : tach) 
            res += x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase() + " ";

        return res.trim();
    }

    @Override
    public int compareTo(SinhVien o) {
        if (o.diemTB == this.diemTB) return this.maSV.compareTo(o.maSV);
        return o.diemTB > this.diemTB ? 1 : -1;
    }

    @Override
    public String toString() {
        return maSV + " " + ten + " " + String.format("%.2f", diemTB);
    }

    public float getDiemTB() {
        return diemTB;
    }
}

public class J07054 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        
        int n = Integer.parseInt(sc.nextLine());
        SinhVien a[] = new SinhVien[n];
        for (int i = 0; i < n; ++i)
            a[i] = new SinhVien(i + 1, sc.nextLine(), Float.parseFloat(sc.nextLine()), Float.parseFloat(sc.nextLine()), Float.parseFloat(sc.nextLine()));

        Arrays.sort(a);

        int rank = 1;
        System.out.println(a[0] + " " + String.valueOf(rank));
        for (int i = 1; i < n; ++i) {
            if (a[i].getDiemTB() != a[i - 1].getDiemTB()) 
                rank = i + 1;
            System.out.println(a[i] + " " + String.valueOf(rank));
        }
        
        sc.close();
    }
}
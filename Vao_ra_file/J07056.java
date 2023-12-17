import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class KhachHang implements Comparable<KhachHang> {
    private String maKH, ten, loaiHo;
    private int chiSoDau, chiSoCuoi;
    private int tienTrongDinhMuc, tienVuotDinhMuc, thueVat;
    private int tongTien;

    public KhachHang(int maKH, String ten, String thongTin) {
        this.maKH = String.format("KH%02d", maKH);
        this.ten = chuanHoa(ten);
        this.tienVuotDinhMuc = 0;
        this.thueVat = 0;

        String tach[] = thongTin.trim().split(" ");
        this.loaiHo = tach[0];
        this.chiSoDau = Integer.parseInt(tach[1]);
        this.chiSoCuoi = Integer.parseInt(tach[2]);

        int soDien = this.chiSoCuoi - this.chiSoDau;
        int dinhMuc;
        if (this.loaiHo.equals("A")) 
            dinhMuc = 100;
        else if (this.loaiHo.equals("B")) 
            dinhMuc = 500;
        else 
            dinhMuc = 200;
        
        if (soDien > dinhMuc) {
            this.tienTrongDinhMuc = 450 * dinhMuc;
            this.tienVuotDinhMuc = 1000 * (soDien - dinhMuc);
            this.thueVat = this.tienVuotDinhMuc * 5 / 100;
        }
        else 
            this.tienTrongDinhMuc = 450 * soDien;
        
        this.tongTien = this.tienTrongDinhMuc + this.tienVuotDinhMuc + this.thueVat;
    }

    private String chuanHoa(String s) {
        String[] tach = s.trim().split("\\s+");
        String res = "";
        
        for (String x : tach) 
            res += x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase() + " ";

        return res.trim();
    }

    @Override
    public int compareTo(KhachHang o) {
        return o.tongTien - this.tongTien;
    }

    @Override
    public String toString() {
        return maKH + " " + ten + " " + tienTrongDinhMuc
                + " " + tienVuotDinhMuc + " " + thueVat + " " + tongTien;
    }
}

public class J07056 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        
        int n = Integer.parseInt(sc.nextLine());
        KhachHang a[] = new KhachHang[n];
        for (int i = 0; i < n; ++i)
            a[i] = new KhachHang(i + 1, sc.nextLine(), sc.nextLine());

        Arrays.sort(a);
        for (int i = 0; i < n; ++i) 
            System.out.println(a[i]);
        
        sc.close();
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

class KhachHang implements Comparable<KhachHang> {
    private String maKH, tenKH, gioiTinh;
    private String diaChi;
    private Date ngaySinh;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public KhachHang(int ma, String tenKH, String gioiTinh, String ngaySinh, String diaChi) throws ParseException {
        this.maKH = String.format("KH%03d", ma);
        this.tenKH = chuanHoaTen(tenKH);
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.ngaySinh = sdf.parse(ngaySinh);
    }

    private String chuanHoaTen(String s) {
        String res = "";
        String[] tach = s.split("\\s+");
        for (String x : tach) 
            res += x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase() + " ";
        return res.trim();
    }

    @Override
    public int compareTo(KhachHang o) {
        return (this.ngaySinh.getTime() > o.ngaySinh.getTime() ? 1 : -1);
    }

    @Override
    public String toString() {
        return maKH + " " + tenKH + " " + gioiTinh + " " + diaChi
                + " " + sdf.format(ngaySinh);
    }
}

public class J07025 {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));

        int n = Integer.parseInt(sc.nextLine());
        KhachHang listKH[] = new KhachHang[n];
        for (int i = 0; i < n; i++) 
            listKH[i] = new KhachHang(i + 1, sc.nextLine().trim(), sc.nextLine(), sc.nextLine(), sc.nextLine());

        Arrays.sort(listKH);
        for (KhachHang kh : listKH) System.out.println(kh);        

        sc.close();
    }
}

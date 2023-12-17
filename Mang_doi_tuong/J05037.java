import java.util.Arrays;
import java.util.Scanner;

class MatHang implements Comparable<MatHang> {
    private String maHang, tenHang, donViTinh;
    private long donGiaNhap, soLuong;
    private long phiVanChuyen, thanhTien, giaBan;

    public MatHang(int ma, String tenHang, String donViTinh, long donGiaNhap, long soLuong) {
        this.maHang = String.format("MH%02d", ma);
        this.tenHang = tenHang;
        this.donViTinh = donViTinh;
        this.donGiaNhap = donGiaNhap;
        this.soLuong = soLuong;

        this.phiVanChuyen = Math.round((this.donGiaNhap * this.soLuong * 5f) / 100);
        this.thanhTien = this.donGiaNhap * this.soLuong + this.phiVanChuyen;
        this.giaBan = Math.round((this.thanhTien * 102f / 100) / this.soLuong);

        if (this.giaBan % 100 > 0) this.giaBan = (this.giaBan / 100 + 1) * 100;
    }

    @Override
    public String toString() {
        return maHang + " " + tenHang + " " + donViTinh + " "
                + phiVanChuyen + " " + thanhTien + " " + giaBan;
    }

    @Override
    public int compareTo(MatHang o) {
        return (this.giaBan > o.giaBan ? -1 : 1);
    }
}

public class J05037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        MatHang a[] = new MatHang[n];
        for (int i = 0; i < n; ++i)
            a[i] = new MatHang(i + 1, sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()));

        Arrays.sort(a);
        for (MatHang x : a) System.out.println(x);

        sc.close();
    }
}

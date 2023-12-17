import java.util.Scanner;

class MatHang {
    private String maHang, tenHang, loaiHang;

    public MatHang(String maHang, String tenHang, String loaiHang) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.loaiHang = loaiHang;
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public String getLoaiHang() {
        return loaiHang;
    }
}

class Ky {
    private String maHang;
    private long soLuongNhap, donGiaNhap, soLuongXuat;
    private long tongGiaTriNhap, tongGiaTriXuat;
    private MatHang objMatHang;

    public Ky(String maHang, long soLuongNhap, long donGiaNhap, long soLuongXuat, MatHang objMatHang) {
        this.maHang = maHang;
        this.soLuongNhap = soLuongNhap;
        this.donGiaNhap = donGiaNhap;
        this.soLuongXuat = soLuongXuat;
        this.objMatHang = objMatHang;

        this.tongGiaTriNhap = this.donGiaNhap * this.soLuongNhap;
        if (this.objMatHang.getLoaiHang().equals("A"))
            this.tongGiaTriXuat = this.donGiaNhap * this.soLuongXuat * 108 / 100;
        else if (this.objMatHang.getLoaiHang().equals("B"))
            this.tongGiaTriXuat = this.donGiaNhap * this.soLuongXuat * 105 / 100;
        else
            this.tongGiaTriXuat = this.donGiaNhap * this.soLuongXuat * 102 / 100;
    }

    @Override
    public String toString() {
        return maHang + " " + objMatHang.getTenHang() + " " + tongGiaTriNhap + " " + tongGiaTriXuat;
    }
    
}

public class J05076 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        MatHang listMH[] = new MatHang[n];
        for (int i = 0; i < n; ++i)
            listMH[i] = new MatHang(sc.nextLine(), sc.nextLine(), sc.nextLine());

        int m = Integer.parseInt(sc.nextLine());
        Ky listKy[] = new Ky[m];
        for (int i = 0; i < m; ++i) {
            String data[] = sc.nextLine().split(" ");
            for (int j = 0; j < n; ++j) {
                if (data[0].equals(listMH[j].getMaHang())) {
                    listKy[i] = new Ky(data[0], Long.parseLong(data[1]), Long.parseLong(data[2]), Long.parseLong(data[3]), listMH[j]);
                    break;
                }
            }
        }

        for (Ky x : listKy) System.out.println(x);
        
        sc.close();
    }
}
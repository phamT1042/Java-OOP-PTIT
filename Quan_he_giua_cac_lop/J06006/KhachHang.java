package Quan_he_giua_cac_lop.J06006;

public class KhachHang {
    private static int cnt = 1;
    private String maKH, tenKH, sex, date, address;
    
    public KhachHang(String tenKH, String sex, String date, String address) {
        this.maKH = String.format("KH%03d", KhachHang.cnt);
        KhachHang.cnt++;
        this.tenKH = tenKH;
        this.sex = sex;
        this.date = date;
        this.address = address;
    }

    public String getMaKH() {
        return maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getAddress() {
        return address;
    }
    
}

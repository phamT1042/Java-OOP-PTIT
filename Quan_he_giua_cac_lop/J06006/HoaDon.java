package Quan_he_giua_cac_lop.J06006;

public class HoaDon implements Comparable<HoaDon> {
    private static int cnt = 1;
    private String maHD, maKH, maMH;
    private long soLuong, thanhTien, loiNhuan;
    private KhachHang kh;
    private MatHang mh;

    public HoaDon(String maKH, String maMH, long soLuong) {
        this.maHD = String.format("HD%03d", HoaDon.cnt);
        HoaDon.cnt++;
        this.maKH = maKH;
        this.maMH = maMH;
        this.soLuong = soLuong;
        this.thanhTien = this.loiNhuan = 0;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public void setMh(MatHang mh) {
        this.mh = mh;
    }

    public void tinhTien() {
        this.thanhTien = this.soLuong * this.mh.getGiaBan();
        this.loiNhuan = this.thanhTien - this.soLuong * this.mh.getGiaMua();
    }

    @Override
    public String toString() {
        return maHD + " " + kh.getTenKH() + " " + kh.getAddress() + " " + mh.getTenMH() + " " + soLuong + " " + thanhTien + " " + loiNhuan;
    }

    @Override
    public int compareTo(HoaDon o) {
        return (this.loiNhuan > o.loiNhuan ? -1 : 1);
    }
}

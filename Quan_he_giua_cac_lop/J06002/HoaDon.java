public class HoaDon implements Comparable<HoaDon> {
    private String maHD;
    private long soLuongMua, soTienGiamGia, soTienPhaiTra;
    private SanPham sp;
    private static int cnt = 1;

    public HoaDon(String maHD, long soLuongMua) {
        this.maHD = maHD + String.format("-%03d", cnt);
        HoaDon.cnt++;
        this.soLuongMua = soLuongMua;
        this.soTienGiamGia = this.soTienPhaiTra = 0;
    }

    public void setSp(SanPham sp) {
        this.sp = sp;
    }

    public void tinhTien() {
        long thanhTien;
        if (this.maHD.charAt(2) == '1') 
            thanhTien = sp.getDonGia1() * this.soLuongMua;
        else
            thanhTien = sp.getDonGia2() * this.soLuongMua;
        
        if (this.soLuongMua >= 150) soTienGiamGia = thanhTien / 2;
        else if (this.soLuongMua >= 100) soTienGiamGia = thanhTien * 3 / 10;
        else if (this.soLuongMua >= 50) soTienGiamGia = thanhTien * 3 / 20;

        this.soTienPhaiTra = thanhTien - this.soTienGiamGia;
    }

    @Override
    public String toString() {
        return maHD + " " + sp.getTenSP() + " " + soTienGiamGia + " " + soTienPhaiTra;
    }

    @Override
    public int compareTo(HoaDon o) {
        return (this.soTienPhaiTra > o.soTienPhaiTra ? -1 : 1);
    }

}

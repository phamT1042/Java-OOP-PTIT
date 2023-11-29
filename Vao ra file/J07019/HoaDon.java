package J07019;

public class HoaDon {
    private String maHD, tenSP;
    private long soLuong, giamGia, phaiTra;

    public HoaDon(int i, String maHD, long soLuong, String tenSP) {
        this.maHD = maHD + String.format("-%03d", i);
        this.soLuong = soLuong;
        this.giamGia = this.phaiTra = 0;
        this.tenSP = tenSP;
    }

    public void tinhToan(long donGia) {
        long thanhTien = donGia * this.soLuong;
        if (this.soLuong >= 150) 
            this.giamGia = thanhTien * 50 / 100;
        else if (this.soLuong >= 100)
            this.giamGia = thanhTien * 30 / 100;
        else if (this.soLuong >= 50)
            this.giamGia = thanhTien * 15 / 100;
        this.phaiTra = thanhTien - this.giamGia;
    }

    @Override
    public String toString() {
        return maHD + " " + tenSP + " " + giamGia + " " + phaiTra;
    }
}

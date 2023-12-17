package J07047;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class KhachHang implements Comparable<KhachHang> {
    private static int STT = 1;
    private String maKH, hoTen, maPhong;
    private Date ngayDen, ngayDi;
    private long soNgay;
    private double tienPhaiTra;

    public KhachHang(String hoTen, String maPhong, Date ngayDen, Date ngayDi) {
        this.maKH = String.format("KH%02d", KhachHang.STT);
        KhachHang.STT++;
        this.hoTen = hoTen;
        this.maPhong = maPhong;
        this.ngayDen = ngayDen;
        this.ngayDi = ngayDi;

        this.soNgay = TimeUnit.MILLISECONDS.toDays((ngayDi.getTime() - ngayDen.getTime()));

        this.tienPhaiTra = 0;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d %.2f", maKH, hoTen, maPhong, soNgay, tienPhaiTra);
    }

    public int compareTo(KhachHang other) {
        return (int) (other.soNgay - this.soNgay);
    }

    public void tinhtien(ArrayList<LoaiPhong> khachSan) {
        String loaiPhong = this.maPhong.substring(2, 3);
        for (LoaiPhong phong : khachSan) {
            if (phong.getLoaiPhong().equals(loaiPhong)) {
                long day = this.soNgay;
                if (day == 0) day = 1;
                this.tienPhaiTra = day * (phong.getDonGiaNgay() * (1 + phong.getPhiPhucVu()));
                break;
            }
        }
        if (this.soNgay >= 10 && this.soNgay < 20) this.tienPhaiTra *= 0.98;
        else if (this.soNgay >= 20 && this.soNgay < 30) this.tienPhaiTra *= 0.96;
        else if (this.soNgay >= 30) this.tienPhaiTra *= 0.94;
    }
}
package J07047;

public class LoaiPhong {
    private String loaiPhong;
    private String tenLoaiPhong;
    private double donGiaNgay, phiPhucVu;

    public LoaiPhong(String loaiPhong, String tenLoaiPhong, double donGiaNgay, double phiPhucVu) {
        this.loaiPhong = loaiPhong;
        this.tenLoaiPhong = tenLoaiPhong;
        this.donGiaNgay = donGiaNgay;
        this.phiPhucVu = phiPhucVu;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public double getDonGiaNgay() {
        return donGiaNgay;
    }

    public double getPhiPhucVu() {
        return phiPhucVu;
    }

}
public class SanPham {
    private String maLoai, tenSP;
    private long donGia1, donGia2;

    public SanPham(String maLoai, String tenSP, long donGia1, long donGia2) {
        this.maLoai = maLoai;
        this.tenSP = tenSP;
        this.donGia1 = donGia1;
        this.donGia2 = donGia2;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public String getTenSP() {
        return tenSP;
    }

    public long getDonGia1() {
        return donGia1;
    }

    public long getDonGia2() {
        return donGia2;
    }
}

package J07019;

public class SanPham {
    private String maLoai, tenSP;
    private long gia1, gia2;
    
    public SanPham(String maLoai, String tenSP, long gia1, long gia2) {
        this.maLoai = maLoai;
        this.tenSP = tenSP;
        this.gia1 = gia1;
        this.gia2 = gia2;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public String getTenSP() {
        return tenSP;
    }

    public long getGia1() {
        return gia1;
    }

    public long getGia2() {
        return gia2;
    }
}

package Quan_he_giua_cac_lop.J06006;

public class MatHang {
    private static int cnt = 1;
    private String maMH, tenMH, donViTinh;
    private long giaMua, giaBan;
    
    public MatHang(String tenMH, String donViTinh, long giaMua, long giaBan) {
        this.maMH = String.format("MH%03d", MatHang.cnt);
        MatHang.cnt++;
        this.tenMH = tenMH;
        this.donViTinh = donViTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public String getMaMH() {
        return maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public long getGiaMua() {
        return giaMua;
    }

    public long getGiaBan() {
        return giaBan;
    }
    
}

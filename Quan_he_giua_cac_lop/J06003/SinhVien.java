public class SinhVien {
    private String maSV, ten, sdt;
    private int stt;

    public SinhVien(String maSV, String ten, String sdt, int stt) {
        this.maSV = maSV;
        this.ten = ten;
        this.sdt = sdt;
        this.stt = stt;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getTen() {
        return ten;
    }

    public String getSdt() {
        return sdt;
    }

    public int getStt() {
        return stt;
    }

    @Override
    public String toString() {
        return maSV + " " + ten + " " + sdt;
    }
}
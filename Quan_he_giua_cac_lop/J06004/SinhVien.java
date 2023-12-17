public class SinhVien implements Comparable<SinhVien> {
    private String maSV, ten, sdt;
    private int stt;
    private NhomBT bt;

    public SinhVien(String maSV, String ten, String sdt, int stt) {
        this.maSV = maSV;
        this.ten = ten;
        this.sdt = sdt;
        this.stt = stt;
    }

    public int getStt() {
        return stt;
    }

    public void setBt(NhomBT bt) {
        this.bt = bt;
    }

    @Override
    public String toString() {
        return maSV + " " + ten + " " + sdt + " " + stt + " " + bt.getTenBT();
    }

    @Override
    public int compareTo(SinhVien o) {
        return this.maSV.compareTo(o.maSV);
    }
}
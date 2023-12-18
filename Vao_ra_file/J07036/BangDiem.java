package J07036;

public class BangDiem implements Comparable<BangDiem> {
    private String maSV, maMH;
    private float diem;
    private SinhVien sv;
    private MonHoc mh;
    
    public BangDiem(String maSV, String maMH, float diem) {
        this.maSV = maSV;
        this.maMH = maMH;
        this.diem = diem;
    }

    public void setSv(SinhVien sv) {
        this.sv = sv;
    }

    public void setMh(MonHoc mh) {
        this.mh = mh;
    }

    public SinhVien getSv() {
        return sv;
    }

    @Override
    public String toString() {
        String res = maSV + " " + sv.getTenSV() + " " + maMH + " " + mh.getTenMon() + " ";
        if (diem == (int)diem) res += String.valueOf((int)diem);
        else res += String.valueOf(diem);
        return res;
    }

    @Override
    public int compareTo(BangDiem o) {
        if (this.maMH.equals(o.maMH)) return this.maSV.compareTo(o.maSV);
        return this.maMH.compareTo(o.maMH);
    }
}

package J07074;

public class NhomLopHoc implements Comparable<NhomLopHoc> {
    private String maNhom, maMon;
    private int ngayDay, kipHoc;
    private String tenGV, phongHoc;

    public NhomLopHoc(int maNhom, String maMon, int ngayDay, int kipHoc, String tenGV, String phongHoc) {
        this.maNhom = String.format("HP%03d", maNhom + 1);
        this.maMon = maMon;
        this.ngayDay = ngayDay;
        this.kipHoc = kipHoc;
        this.tenGV = tenGV;
        this.phongHoc = phongHoc;
    }

    public String getMaMon() {
        return maMon;
    }

    @Override
    public String toString() {
        return maNhom + " " + ngayDay + " " + kipHoc + " " + tenGV + " " + phongHoc;
    }

    @Override
    public int compareTo(NhomLopHoc o) {
        if (this.ngayDay != o.ngayDay) return this.ngayDay - o.ngayDay;
        return this.kipHoc - o.kipHoc;
    }
}

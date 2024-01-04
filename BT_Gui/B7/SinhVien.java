package B7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SinhVien implements Comparable<SinhVien> {
    private String maSV, ten, lop;
    private Date ngaySinh;
    private double gpa;
    private static int STT = 1;

    public SinhVien(String ten, String lop, String ngaySinhStr, double gpa) throws ParseException {
        this.maSV = String.format("B20DCCN%03d", SinhVien.STT);
        SinhVien.STT++;
        this.ten = ten;
        this.lop = lop;
        this.ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(ngaySinhStr);
        this.gpa = gpa;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getTen() {
        return ten;
    }

    public String getLop() {
        return lop;
    }

    public String getNgaySinh() {
        return new SimpleDateFormat("dd/MM/yyyy").format(ngaySinh);
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public int compareTo(SinhVien o) {
        return Double.compare(this.gpa, o.gpa);
    } 
}

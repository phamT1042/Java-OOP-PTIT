import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class SinhVien {
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


    @Override
    public String toString() {
        return maSV + " " + ten + " " + lop + " " + (new SimpleDateFormat("dd/MM/yyyy").format(ngaySinh)) + " " + String.format("%.2f", gpa);
    }
}

public class J07010 {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("SV.in"));

        int n = Integer.parseInt(sc.nextLine());
        SinhVien dsSV[] = new SinhVien[n];

        for (int i = 0; i < n; i++) 
            dsSV[i] = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()));
        
        for (SinhVien x : dsSV)
            System.out.println(x);

        sc.close();
    }
}
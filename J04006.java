import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

class SinhVien {
    private String maSV, hoTen, lop;
    private Date ngaySinh;
    private float gpa;

    public SinhVien() {
        this.maSV = "B20DCCN001";
        this.hoTen = this.lop;
        gpa = 0;
    }

    public static SinhVien input(Scanner scan) throws ParseException {
        SinhVien sv = new SinhVien();
        sv.hoTen = scan.nextLine();
        sv.lop = scan.next();
        sv.ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(scan.next());
        sv.gpa = scan.nextFloat();
        return sv;
    }
    public String toString() {
        return maSV + " " + hoTen + " " + lop + " " + new SimpleDateFormat("dd/MM/yyyy").format(ngaySinh) + " " + String.format("%.2f", gpa);
    }
}
public class J04006 {
    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);
        SinhVien sv = SinhVien.input(scan);
        System.out.println(sv);
        scan.close();
    }
}

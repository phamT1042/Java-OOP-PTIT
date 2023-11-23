import java.util.Scanner;

class ThiSinh {
    private String ma, ten, trangThai;
    private double a, b, c, uuTien, tongDiem;

    public ThiSinh(String ma, String ten, double a, double b, double c) {
        this.ma = ma;
        this.ten = ten;
        this.a = a;
        this.b = b;
        this.c = c;
        if (this.ma.charAt(2) == '1') this.uuTien = 0.5;
        else if (this.ma.charAt(2) == '2') this.uuTien = 1.0;
        else this.uuTien = 2.5;
        this.tongDiem = 2 * this.a + this.b + this.c;
        if (this.tongDiem + this.uuTien >= 24) this.trangThai = "TRUNG TUYEN";
        else this.trangThai = "TRUOT";
    }

    public String getUuTien() {
        if (uuTien == 1) return "1";
        return Double.toString(uuTien);
    }

    public String getTongDiem() {
        if (tongDiem % 1 == 0) return String.format("%.0f", tongDiem);
        return String.format("%.1f", tongDiem);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + getUuTien() + " " + getTongDiem() + " " + trangThai;
    }

}

public class J04013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(new ThiSinh(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));

        sc.close();
    }
}
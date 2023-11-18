import java.util.Scanner;

class GiaoVien {
    private String maNgach, hoTen;
    private long luongCoBan, phuCap, thuNhap, heSoLuong;

    public GiaoVien(String maNgach, String hoTen, long luongCoBan) {
        this.maNgach = maNgach;
        this.hoTen = hoTen;
        this.luongCoBan = luongCoBan;

        this.heSoLuong = Integer.parseInt(this.maNgach.substring(2));
        if (maNgach.charAt(1) == 'T') this.phuCap = 2_000_000;
        else if (maNgach.charAt(1) == 'P') this.phuCap = 900_000;
        else this.phuCap = 500_000;
        this.thuNhap = this.heSoLuong * this.luongCoBan + this.phuCap;
    }

    public String toString() {
        return maNgach + " " + hoTen + " " + heSoLuong + " " + phuCap + " " + thuNhap;
    }

}
public class J04015 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println(new GiaoVien(scan.nextLine(), scan.nextLine(), scan.nextLong()));
        
        scan.close();
    }
}

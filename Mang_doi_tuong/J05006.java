import java.util.Scanner;

class NhanVien {
    private String ma, ten, gt, ns, dc, msthue, ngaykyhd;

    public NhanVien(int ma, String ten, String gt, String ns, String dc, String msthue, String ngaykyhd) {
        this.ma = String.format("%05d", ma);
        this.ten = ten;
        this.gt = gt;
        this.ns = ns;
        this.dc = dc;
        this.msthue = msthue;
        this.ngaykyhd = ngaykyhd;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + gt + " " + ns + " " + dc + " " + msthue + " " + ngaykyhd;
    }
    
}

public class J05006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        NhanVien save[] = new NhanVien[n];
        for (int i = 0; i < n; ++i)
            save[i] = new NhanVien(i + 1, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
        for (NhanVien x : save) System.out.println(x);

        sc.close();
    }
}

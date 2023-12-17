import java.util.Arrays;
import java.util.Scanner;

class SinhVien implements Comparable<SinhVien> {
    private int STT;
    private String ma, ten, lop, email, dn;
    private static int cnt = 1;

    public SinhVien(String ma, String ten, String lop, String email, String dn) {
        this.STT = cnt++;
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.email = email;
        this.dn = dn;
    }

    public String getDn() {
        return dn;
    }

    @Override
    public String toString() {
        return STT + " " + ma + " " + ten + " " + lop + " " + email + " " + dn;
    }

    @Override
    public int compareTo(SinhVien o) {
        return this.ma.compareTo(o.ma);
    }
}

public class J05035 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        SinhVien a[] = new SinhVien[n];
        
        for (int i = 0; i < n; i++) 
            a[i] = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
        Arrays.sort(a);

        int q = sc.nextInt();
        while (q-- > 0) {
            String DN = sc.next();
            for (int i = 0; i < n; i++) 
                if (a[i].getDn().equals(DN)) System.out.println(a[i]);     
        }

        sc.close();
    }

}
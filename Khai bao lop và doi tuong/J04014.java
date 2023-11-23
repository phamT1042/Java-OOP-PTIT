import java.util.Scanner;

class PhanSo {
    private long tu, mau;

    public PhanSo(long tu, long mau) {
        this.tu = tu;
        this.mau = mau;
    }

    public static long gcd (long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public void rutGon() {
        long share = gcd(this.tu, this.mau);
        this.tu /= share;
        this.mau /= share;
    }

    public static PhanSo calC (PhanSo a, PhanSo b) {
        long mauChung = (a.mau * b.mau) / gcd(a.mau, b.mau);
        PhanSo c = new PhanSo(a.tu * (mauChung / a.mau) + b.tu * (mauChung / b.mau), mauChung);
        c.tu *= c.tu;
        c.mau *= c.mau;
        c.rutGon();
        return c;
    }

    public static void calCD (PhanSo a, PhanSo b) {
        PhanSo c = PhanSo.calC(a, b);
        PhanSo d = new PhanSo(a.tu * b.tu * c.tu, a.mau * b.mau * c.mau);
        d.rutGon();
        System.out.println(c + " " + d);
    }

    @Override
    public String toString() {
        return tu + "/" + mau;
    }
    
}

public class J04014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            PhanSo a = new PhanSo(sc.nextLong(), sc.nextLong());
            PhanSo b = new PhanSo(sc.nextLong(), sc.nextLong());
            PhanSo.calCD(a, b);
        }

        sc.close();
    }
}
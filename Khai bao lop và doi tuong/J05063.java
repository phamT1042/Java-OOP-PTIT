import java.util.Scanner;

class DaThuc {
    private int a[];

    public DaThuc(String s) {
        a = new int[10001];
        if (s.isEmpty()) return;
        String[] tach = s.trim().split(" ");
        for (String x : tach) {
            if (x.equals("+")) continue;
            String[] t = x.split("[*^]");
            a[Integer.parseInt(t[2])] += Integer.parseInt(t[0]);
        }
    }

    public DaThuc cong (DaThuc o) {
        DaThuc sum = new DaThuc("");
        for (int i = 0; i < 10001; ++i) sum.a[i] = this.a[i] + o.a[i];
        return sum;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 10000; i >= 0; i--)
            if (this.a[i] > 0) res += String.format("%d*x^%d + ", this.a[i], i);
        return res.substring(0, res.length() - 3);
    }
}

public class J05063 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            DaThuc p = new DaThuc(sc.nextLine());
            DaThuc q = new DaThuc(sc.nextLine());
            DaThuc r = p.cong(q);
            System.out.println(r);
        }
    }
}

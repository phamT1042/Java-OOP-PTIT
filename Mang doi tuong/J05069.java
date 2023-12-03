import java.util.Scanner;

class CLB {
    private String maCLB, tenCLB;
    private long giaVe;

    public CLB(String maCLB, String tenCLB, long giaVe) {
        this.maCLB = maCLB;
        this.tenCLB = tenCLB;
        this.giaVe = giaVe;
    }

    public String getMaCLB() {
        return this.maCLB;
    }

    public String getTenClb() {
        return this.tenCLB;
    }

    public long getGiaVe() {
        return this.giaVe;
    }
}

class TranDau {
    private String maTranDau;
    private long soCDV, doanhThu;
    private CLB clb;

    public TranDau (String maTranDau, long soCDV, CLB clb) {
        this.maTranDau = maTranDau;
        this.soCDV = soCDV;
        this.clb = clb;

        this.doanhThu = this.soCDV * clb.getGiaVe();
    }

    public String toString() {
        return this.maTranDau + " " + this.clb.getTenClb() + " " + this.doanhThu;
    }
}

public class J05069 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        CLB listClb[] = new CLB[n];
        for (int i = 0; i < n; ++i)
            listClb[i] = new CLB(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()));
        
        int m = Integer.parseInt(sc.nextLine());
        TranDau listTD[] = new TranDau[m];
        for (int i = 0; i < m; ++i) {
            String data[] = sc.nextLine().split(" ");
            for (int j = 0; j < n; ++j) {
                if (listClb[j].getMaCLB().equals(data[0].substring(1, 3))) {
                    listTD[i] = new TranDau(data[0], Long.parseLong(data[1]), listClb[j]);
                    break;
                }
            }
        }

        for (TranDau x : listTD) System.out.println(x);

        sc.close();
    }
}

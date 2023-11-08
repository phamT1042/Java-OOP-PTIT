import java.util.Arrays;
import java.util.Scanner;

class DoanhNghiep implements Comparable<DoanhNghiep> {
    private String ma, ten;
    private int sv;

    public DoanhNghiep(String ma, String ten, int sv) {
        this.ma = ma;
        this.ten = ten;
        this.sv = sv;
    }

    public int getSv() {
        return sv;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + sv;
    }

    @Override
    public int compareTo(DoanhNghiep o) {
        if (this.sv != o.sv) return o.sv - this.sv;
        return this.ma.compareTo(o.ma);
    }
}

public class J05029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        DoanhNghiep save[] = new DoanhNghiep[n];
        for (int i = 0; i < n; i++) 
            save[i] = new DoanhNghiep(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));
        
        Arrays.sort(save);  
        int q = sc.nextInt();
        while (q-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt();
            System.out.printf("DANH SACH DOANH NGHIEP NHAN TU %d DEN %d SINH VIEN:\n", a, b);
            for (int i = 0; i < n; i++) {
                if (save[i].getSv() >= a && save[i].getSv() <= b) System.out.println(save[i]);
                else if (save[i].getSv() < a) break;
            }
        }

        sc.close();
    }
}

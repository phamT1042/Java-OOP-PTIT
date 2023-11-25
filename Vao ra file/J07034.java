import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class MonHoc implements Comparable<MonHoc> {
    private String maMon, tenMon;
    private int soTC;
    
    public MonHoc(String maMon, String tenMon, int soTC) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.soTC = soTC;
    }

    @Override
    public int compareTo(MonHoc o) {
        return tenMon.compareTo(o.tenMon);
    }

    @Override
    public String toString() {
        return maMon + " " + tenMon + " " + soTC;
    }
}

public class J07034 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));

        int n = Integer.parseInt(sc.nextLine());
        MonHoc a[] = new MonHoc[n];
        for (int i = 0; i < n; ++i)
            a[i] = new MonHoc(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));

        Arrays.sort(a);
        for (MonHoc x : a) System.out.println(x);

        sc.close();
    }
}

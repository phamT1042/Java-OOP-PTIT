import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class DN implements Comparable<DN> {
    private String maDN, tenDN;
    private int soSV;
    
    public DN(String maDN, String tenDN, int soSV) {
        this.maDN = maDN;
        this.tenDN = tenDN;
        this.soSV = soSV;
    }

    @Override
    public int compareTo(DN o) {
        return maDN.compareTo(o.maDN);
    }

    @Override
    public String toString() {
        return maDN + " " + tenDN + " " + soSV;
    }
}

public class J07037 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DN.in"));

        int n = Integer.parseInt(sc.nextLine());
        DN a[] = new DN[n];
        for (int i = 0; i < n; ++i)
            a[i] = new DN(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));

        Arrays.sort(a);
        for (DN x : a) System.out.println(x);

        sc.close();
    }
}

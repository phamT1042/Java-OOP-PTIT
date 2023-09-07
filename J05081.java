import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class MatHang {
    private static int start = 1;
    private String maMH, tenMH, donViTinh;
    private long giaMua, giaBan, loiNhuan;

    public MatHang(String tenMH, String donViTinh, long giaMua, long giaBan) {
        this.tenMH = tenMH;
        this.donViTinh = donViTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
        this.loiNhuan = this.giaBan - this.giaMua;

        String maMH = Integer.toString(start);
        while (maMH.length() < 3) maMH = "0" + maMH;
        this.maMH = "MH" + maMH;

        start++;
    }

    public String getMaMH() {
        return maMH;
    }

    public long getLoiNhuan() {
        return loiNhuan;
    }

    public String toString() {
        return maMH + " " + tenMH + " " + donViTinh + " " + giaMua + " " + giaBan + " " + loiNhuan;
    }
}
public class J05081 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<MatHang> list = new ArrayList<>();

        int t = Integer.parseInt(scan.nextLine());
        while (t-- > 0) 
            list.add(new MatHang(scan.nextLine(), scan.nextLine(), Long.parseLong(scan.nextLine()), Long.parseLong(scan.nextLine())));

        Collections.sort(list, new Comparator<MatHang>() {
            @Override
            public int compare(MatHang mh1, MatHang mh2) {
                if (mh1.getLoiNhuan() != mh2.getLoiNhuan()) return Long.compare(mh2.getLoiNhuan(), mh1.getLoiNhuan());
                return mh1.getMaMH().compareTo(mh2.getMaMH());
            }
        });

        for (MatHang x : list) System.out.println(x);

        scan.close();
    }
}

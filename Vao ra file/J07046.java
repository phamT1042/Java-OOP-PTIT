import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Khach implements Comparable<Khach> {
    private String maKH, tenKH, maPhong;
    private Date ngayDen, ngayDi;
    private long luuTru;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Khach(int maKH, String tenKH, String maPhong, String ngayDen, String ngayDi) throws ParseException {
        this.maKH = String.format("KH%02d", maKH);
        this.tenKH = tenKH;
        this.maPhong = maPhong;
        this.ngayDen = sdf.parse(ngayDen);
        this.ngayDi = sdf.parse(ngayDi);

        luuTru = TimeUnit.MILLISECONDS.toDays(this.ngayDi.getTime() - this.ngayDen.getTime());
    }

    @Override
    public String toString() {
        return maKH + " " + tenKH + " " + maPhong + " " + luuTru;
    }

    @Override
    public int compareTo(Khach o) {
        return (o.luuTru > this.luuTru ? 1 : -1);
    }
}

public class J07046 {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("KHACH.in"));

        int n = Integer.parseInt(sc.nextLine());
        Khach a[] = new Khach[n];
        for (int i = 0; i < n; i++)
            a[i] = new Khach(i + 1, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
        
        Arrays.sort(a);
        for (Khach x : a) System.out.println(x);
        
        sc.close();
    }
}
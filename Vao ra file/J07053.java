import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ThiSinh {
    private String maTS, ten;
    private int tuoi, diemTB;
    private String xepLoai;

    public ThiSinh(int ma, String ten, String date, float diem1, float diem2) {
        this.maTS = String.format("PH%02d", ma);
        this.ten = chuanHoa(ten);
        this.tuoi = 2021 - Integer.parseInt(date.substring(date.length() - 4));

        if (diem1 >= 8 && diem2 >= 8) diem1 += 2;
        else if (diem1 >= 7.5 && diem2 >= 7.5) diem1 += 1;
        this.diemTB = Math.round((diem1 + diem2) / 2);
        this.diemTB = (this.diemTB > 10 ? 10 : this.diemTB);

        if (this.diemTB < 5) this.xepLoai = "Truot";
        else if (this.diemTB <= 6) this.xepLoai = "Trung binh";
        else if (this.diemTB <= 7) this.xepLoai = "Kha";
        else if (this.diemTB <= 8) this.xepLoai = "Gioi";
        else this.xepLoai = "Xuat sac";
    }

    private String chuanHoa(String s) {
        String[] tach = s.trim().split("\\s+");
        String res = "";
        
        for (String x : tach) 
            res += x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase() + " ";

        return res.trim();
    }

    @Override
    public String toString() {
        return maTS + " " + ten + " " + tuoi + " " + diemTB + " " + xepLoai;
    }
}

public class J07053 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("XETTUYEN.in"));
        
        int n = Integer.parseInt(sc.nextLine());
        ThiSinh a[] = new ThiSinh[n];
        for (int i = 0; i < n; ++i)
            a[i] = new ThiSinh(i + 1, sc.nextLine(), sc.nextLine(), Float.parseFloat(sc.nextLine()), Float.parseFloat(sc.nextLine()));

        for (int i = 0; i < n; ++i) 
            System.out.println(a[i]);
        
        sc.close();
    }
}
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

class SV {
    private String maSV, ten, lop;
    private Date date;
    private float gpa;
    private static int stt = 1;
    
    public SV(String ten, String lop, String date, float gpa) throws ParseException {
        this.maSV = "B20DCCN" + String.format("%03d", stt);
        SV.stt++;
        this.ten = chuanHoa(ten);
        this.lop = lop;
        this.date = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        this.gpa = gpa;
    }

    public static String chuanHoa(String s) {
        String[] tach = s.trim().split("\\s+");
        String res = "";
        for (String x : tach) 
                res += x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase() + " ";
        return res;
    }

    @Override
    public String toString() {
        return maSV + " " + ten + lop + " " + new SimpleDateFormat("dd/MM/yyyy").format(date) + " " + String.format("%.2f", gpa);
    }

    public float getGpa() {
        return gpa;
    }    
}

class SortGPA implements Comparator<SV> {
    @Override
    public int compare(SV a, SV b) {
        if (a.getGpa() < b.getGpa()) return 1;
        return -1;
    }
}

public class J05005 {
    public static void main(String[] args) throws NumberFormatException, ParseException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        SV a[] = new SV[n];
        for (int i = 0; i < n; i++) 
            a[i] = new SV(sc.nextLine(), sc.nextLine(), sc.nextLine(), Float.parseFloat(sc.nextLine()));
        
        Arrays.sort(a, new SortGPA());
        for (SV x : a) System.out.println(x);

        sc.close();
    }
}

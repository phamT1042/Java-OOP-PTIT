import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class VDV implements Comparable<VDV> {
    private static int cnt = 1;
    private String ma, ten;
    private String date;
    private Date start, end; 
    String uuTien, thanhTich, thanhTichThucTe;
    private SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

    public VDV(String ten, String date, String start, String end) throws ParseException {
        this.ma = String.format("VDV%02d", VDV.cnt);
        VDV.cnt++;
        this.ten = ten;
        this.date = date;
        this.start = sdf.parse(start);
        this.end = sdf.parse(end);

        long time = TimeUnit.MILLISECONDS.toSeconds(this.end.getTime() - this.start.getTime());
        long hours = time / 3600;
        long minus = (time - hours * 3600) / 60;
        long second = time - 3600 * hours - 60 * minus;
        thanhTichThucTe = String.format("%02d:%02d:%02d", hours, minus, second);

        int tuoi = 2021 - Integer.parseInt(this.date.substring(6));
        if (tuoi >= 32) {
            time -= 3;
            uuTien = "00:00:03";
        }
        else if (tuoi >= 25) {
            time -= 2;
            uuTien = "00:00:02";
        }
        else if (tuoi >= 18) {
            time -= 1;
            uuTien = "00:00:01";
        }
        else {
            uuTien = "00:00:00";
        }
        
        hours = time / 3600;
        minus = (time - hours * 3600) / 60;
        second = time - 3600 * hours - 60 * minus;
        thanhTich = String.format("%02d:%02d:%02d", hours, minus, second);
    }

    public String getThanhTich() {
        return thanhTich;
    }

    public String toString(int rank) {
        return ma + " " + ten + " " + thanhTichThucTe + " " + uuTien + " " + thanhTich + " " + rank;
    }

    @Override
    public int compareTo(VDV o) {
        return this.thanhTich.compareTo(o.thanhTich);
    }
    
}

public class J05056 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        VDV listVDV[] = new VDV[n];
        for (int i = 0; i < n; ++i)
            listVDV[i] = new VDV(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());

        Arrays.sort(listVDV);
        System.out.println(listVDV[0].toString(1));
        int rank = 1;
        for (int i = 1; i < n; ++i) {
            if (!listVDV[i].getThanhTich().equals(listVDV[i - 1].getThanhTich())) 
                rank = i + 1;
            System.out.println(listVDV[i].toString(rank));
        }

        sc.close();
    }
}
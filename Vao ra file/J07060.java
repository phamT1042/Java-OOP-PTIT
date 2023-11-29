import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class MonThi {
    private String ma, ten, hinhThucthi;

    public MonThi(String ma, String ten, String hinhThucthi) {
        this.ma = ma;
        this.ten = ten;
        this.hinhThucthi = hinhThucthi;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

}

class CaThi {
    private String ma, gioThi, phongThi, ngayThi;

    public CaThi(int i, String ngayThi, String gioThi, String phongThi) {
        this.ma = "C";
        for (int j = 0; j < 3 - String.valueOf(i).length(); j++) this.ma += "0";
        this.ma += String.valueOf(i);
        this.gioThi = gioThi;
        this.phongThi = phongThi;
        this.ngayThi = ngayThi;
    }

    public String getMa() {
        return ma;
    }

    public String getGioThi() {
        return gioThi;
    }

    public String getPhongThi() {
        return phongThi;
    }

    public String getNgayThi() {
        return ngayThi;
    } 

}

class LichThi implements Comparable<LichThi> {
    private String maCaThi, maMon, nhomLop, soSV;
    private String ngayThi, gioThi, phongThi, tenMon;

    public LichThi(String maCaThi, String maMon, String nhomLop, String soSV) {
        this.maCaThi = maCaThi;
        this.maMon = maMon;
        this.nhomLop = nhomLop;
        this.soSV = soSV;
    }

    public String getMaMon() {
        return maMon;
    }

    public String getMaCaThi() {
        return maCaThi;
    }

    public void setNgayThi(String ngayThi) {
        this.ngayThi = ngayThi;
    }

    public void setGioThi(String gioThi) {
        this.gioThi = gioThi;
    }

    public void setPhongThi(String phongThi) {
        this.phongThi = phongThi;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    @Override
    public String toString() {
        return ngayThi + " " + gioThi + " " + phongThi + " " + tenMon + " " + nhomLop + " " + soSV;
    }

    @Override
    public int compareTo(LichThi o) {
        if (this.ngayThi.equals(o.ngayThi)) {
            if (this.gioThi.equals(o.gioThi)) {
                return this.maCaThi.compareTo(o.maCaThi);
            }
            return this.gioThi.compareTo(o.gioThi);
        }
        String date1 = this.ngayThi.substring(6, 10) + this.ngayThi.substring(3, 5) + this.ngayThi.substring(0, 2);
        String date2 = o.ngayThi.substring(6, 10) + o.ngayThi.substring(3, 5) + o.ngayThi.substring(0, 2);
        return 1;
    }
}

public class J07060 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner readMonThi = new Scanner(new File("MONTHI.in"));
        Scanner readCaThi = new Scanner(new File("CATHI.in"));
        Scanner readLichThi = new Scanner(new File("LICHTHI.in"));

        //Doc mon thi
        int n = Integer.parseInt(readMonThi.nextLine());
        MonThi dsMonThi[] = new MonThi[n];
        for (int i = 0; i < n; i++) 
            dsMonThi[i] = new MonThi(readMonThi.nextLine(), readMonThi.nextLine(), readMonThi.nextLine()); 
        readMonThi.close();

        //Doc ca thi
        int m = Integer.parseInt(readCaThi.nextLine());
        CaThi dsCaThi[] = new CaThi[m];
        for (int i = 0; i < m; i++) 
            dsCaThi[i] = new CaThi(i + 1, readCaThi.nextLine(), readCaThi.nextLine(), readCaThi.nextLine());
        
        readCaThi.close();

        //Doc lich thi
        int k = Integer.parseInt(readLichThi.nextLine());
        LichThi dsLichThi[] = new LichThi[k];
        for (int i = 0; i < k; i++) {
            String tach[] = readLichThi.nextLine().split(" ");
            dsLichThi[i] = new LichThi(tach[0], tach[1], tach[2], tach[3]);
            for (int j = 0; j < n; j++) {
                if (dsMonThi[j].getMa().equals(dsLichThi[i].getMaMon())) {
                    dsLichThi[i].setTenMon(dsMonThi[j].getTen()); 
                    break;
                }
            }
            for (int t = 0; t < m; t++) {
                if (dsCaThi[t].getMa().equals(dsLichThi[i].getMaCaThi())) {
                    dsLichThi[i].setGioThi(dsCaThi[t].getGioThi());
                    dsLichThi[i].setNgayThi(dsCaThi[t].getNgayThi());
                    dsLichThi[i].setPhongThi(dsCaThi[t].getPhongThi());
                    break;
                }
            }
        }
        readLichThi.close();

        Arrays.sort(dsLichThi);
        for (LichThi x : dsLichThi) System.out.println(x);
    }  
}

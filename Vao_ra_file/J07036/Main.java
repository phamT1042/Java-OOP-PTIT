package J07036;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inpSV = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(inpSV.nextLine());
        SinhVien listSV[] = new SinhVien[n];
        for (int i = 0; i < n; ++i) 
            listSV[i] = new SinhVien(inpSV.nextLine(), inpSV.nextLine(), inpSV.nextLine(), inpSV.nextLine());
        inpSV.close();

        Scanner inpMH = new Scanner(new File("MONHOC.in"));
        int m = Integer.parseInt(inpMH.nextLine());
        MonHoc listMH[] = new MonHoc[m];
        for (int i = 0; i < m; ++i) 
            listMH[i] = new MonHoc(inpMH.nextLine(), inpMH.nextLine(), Integer.parseInt(inpMH.nextLine()));
        inpMH.close();

        Scanner inpBD = new Scanner(new File("BANGDIEM.in"));
        int k = Integer.parseInt(inpBD.nextLine());
        BangDiem listBD[] = new BangDiem[k];
        for (int i = 0; i < k; ++i) {
            String data[] = inpBD.nextLine().split(" ");
            listBD[i] = new BangDiem(data[0], data[1], Float.parseFloat(data[2]));

            for (int j = 0; j < n; ++j) {
                if (listSV[j].getMaSV().equals(data[0])) {
                    listBD[i].setSv(listSV[j]);
                    break;
                }
            }

            for (int j = 0; j < m; ++j) {
                if (listMH[j].getMaMon().equals(data[1])) {
                    listBD[i].setMh(listMH[j]);
                    break;
                }
            }
        } 

        Arrays.sort(listBD);
        int q = Integer.parseInt(inpBD.nextLine());
        while (q-- > 0) {
            String lop = inpBD.nextLine();
            System.out.printf("BANG DIEM lop %s:\n", lop);
            for (BangDiem x : listBD) 
                if (x.getSv().getLop().equals(lop)) System.out.println(x);
        }
            
        inpBD.close();
    }
}

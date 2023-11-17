package J07074;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int n = Integer.parseInt(sc.nextLine());
        MonHoc listMH[] = new MonHoc[n];
        for (int i = 0; i < n; i++)
            listMH[i] = new MonHoc(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));

        sc = new Scanner(new File("LICHGD.in"));
        int m = Integer.parseInt(sc.nextLine());
        NhomLopHoc listGD[] = new NhomLopHoc[m];
        for (int i = 0; i < m; ++i) 
            listGD[i] = new NhomLopHoc(i, sc.nextLine(), Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine());
        Arrays.sort(listGD);

        String maMH = sc.nextLine();
        sc.close();

        String tenMH = "";
        for (MonHoc mh : listMH)
            if (mh.getMaMon().equals(maMH)) {
                tenMH = mh.getTenMon();
                break;
            }

        System.out.printf("LICH GIANG DAY MON %s:\n", tenMH);
        for (NhomLopHoc nlh : listGD) 
            if (nlh.getMaMon().equals(maMH)) System.out.println(nlh);
    }
}

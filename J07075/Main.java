package J07075;

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

        String tenGV = sc.nextLine();
        sc.close();

        System.out.printf("LICH GIANG DAY GIANG VIEN %s:\n", tenGV);
        for (int i = 0; i < m; ++i) 
            if (listGD[i].getTenGV().equals(tenGV)) {
                String tenMH = "";
                for (int j = 0; j < n; ++j) {
                    if (listMH[j].getMaMon().equals(listGD[i].getMaMon())) {
                        tenMH = listMH[j].getTenMon();
                        break;
                    }
                }
                System.out.println(listGD[i].toString(tenMH));
            }
    }
}

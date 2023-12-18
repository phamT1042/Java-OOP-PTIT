package Quan_he_giua_cac_lop.J06008;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        MonHoc listMH[] = new MonHoc[n];
        String data[];

        for (int i = 0; i < n; ++i) {
            data = sc.nextLine().split(" ");
            String nameMH = "";
            for (int j = 1; j < data.length; ++j) nameMH += data[j] + " ";
            listMH[i] = new MonHoc(data[0], nameMH.trim());
        }

        int m = Integer.parseInt(sc.nextLine());
        GiangVien listGV[] = new GiangVien[m];
        for (int i = 0; i < m; ++i) {
            data = sc.nextLine().split(" ");
            String nameGV = "";
            for (int j = 1; j < data.length; ++j) nameGV += data[j] + " ";
            listGV[i] = new GiangVien(data[0], nameGV.trim()); 
        }

        int q = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < q; ++i) {
            data = sc.nextLine().split(" ");
            MonHoc curMH = new MonHoc();

            for (int j = 0; j < n; ++j) {
                if (listMH[j].getMaMon().equals(data[1])) {
                    curMH = listMH[j];
                    break;
                }
            }

            for (int j = 0; j < m; ++j) {
                if (listGV[j].getMaGV().equals(data[0])) {
                    listGV[j].addLopHP(new Pair(curMH, Float.parseFloat(data[2])));
                    break;
                }
            }
        }

        String findGV = sc.nextLine();
        for (GiangVien x : listGV)
            if (x.getMaGV().equals(findGV)) {
                System.out.println(x);
                break;
            }

        sc.close();
    }
}

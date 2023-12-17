package Quan_he_giua_cac_lop.J06006;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        KhachHang listKH[] = new KhachHang[n];
        for (int i = 0; i < n; ++i) 
            listKH[i] = new KhachHang(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
        
        int m = Integer.parseInt(sc.nextLine());
        MatHang listMH[] = new MatHang[m];
        for (int i = 0; i < m; ++i)
            listMH[i] = new MatHang(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()));

        int k = Integer.parseInt(sc.nextLine());
        HoaDon listHD[] = new HoaDon[k];
        for (int i = 0; i < k; ++i) {
            String data[] = sc.nextLine().split(" ");
            listHD[i] = new HoaDon(data[0], data[1], Long.parseLong(data[2]));

            for (int j = 0; j < n; ++j) {
                if (listKH[j].getMaKH().equals(data[0])) {
                    listHD[i].setKh(listKH[j]);
                    break;
                }
            }

            for (int j = 0; j < m; ++j) {
                if (listMH[j].getMaMH().equals(data[1])) {
                    listHD[i].setMh(listMH[j]);
                    break;
                }
            }

            listHD[i].tinhTien();
        }

        Arrays.sort(listHD);
        for (HoaDon x : listHD) System.out.println(x);

        sc.close();
    }
}

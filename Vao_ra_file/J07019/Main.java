package J07019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA1.in"));
        int n = Integer.parseInt(sc.nextLine());
        SanPham listSP[] = new SanPham[n];
        for (int i = 0; i < n; ++i)
            listSP[i] = new SanPham(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()));
        
        sc.close();
        sc = new Scanner(new File("DATA2.in"));
        int m = Integer.parseInt(sc.nextLine());
        HoaDon listHD[] = new HoaDon[m];
        for (int i = 0; i < m; ++i) {
            String tach[] = sc.nextLine().trim().split(" ");

            String maSP = tach[0].substring(0, tach[0].length() - 1);
            String loai = tach[0].substring(tach[0].length() - 1);

            for (SanPham x : listSP) {
                if (x.getMaLoai().equals(maSP)) {
                    listHD[i] = new HoaDon(i + 1, tach[0], Long.parseLong(tach[1]), x.getTenSP());
                    if (loai.equals("1"))
                        listHD[i].tinhToan(x.getGia1());
                    else
                        listHD[i].tinhToan(x.getGia2());
                    break;
                }
            }            
        }

        for (HoaDon x : listHD) System.out.println(x);
        
        sc.close();
    }
}

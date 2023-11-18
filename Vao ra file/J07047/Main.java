package J07047;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("DATA.in"));
        
        ArrayList<LoaiPhong> khachSan = new ArrayList<>();
        ArrayList<KhachHang> dsKH = new ArrayList<>();

        int soPhong = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < soPhong; i++) {
            String[] phong = sc.nextLine().split(" ");
            khachSan.add(new LoaiPhong(phong[0], phong[1], Double.parseDouble(phong[2]), Double.parseDouble(phong[3])));
        }

        int soKH = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < soKH; i++) {
            KhachHang kh = new KhachHang(sc.nextLine(), sc.nextLine(), new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine()), new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine()));
            kh.tinhtien(khachSan);
            dsKH.add(kh);
        }

        Collections.sort(dsKH);

        for (KhachHang x : dsKH) System.out.println(x);
        
        sc.close();
    }
}
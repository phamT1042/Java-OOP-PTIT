import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class LoaiPhong implements Comparable<LoaiPhong> {
    private String loaiPhong, tenPhong, donGia, phiPV;

    public LoaiPhong(String s) {
        String tach[] = s.split(" ");
        this.loaiPhong = tach[0];
        this.tenPhong = tach[1];
        this.donGia = tach[2];
        this.phiPV = tach[3];
    }

    @Override
    public String toString() {
        return loaiPhong + " " + tenPhong + " " + donGia + " " + phiPV;
    }

    @Override
    public int compareTo(LoaiPhong o) {
        return tenPhong.compareTo(o.tenPhong);
    }
}

public class J07045 {
    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }
}

import java.util.*;
import java.io.*;

class MonThi {
    private String ma, ten, hinh_thuc;

    public MonThi(String ma, String ten, String hinh_thuc){
        this.ma = ma;
        this.ten = ten;
        this.hinh_thuc = hinh_thuc;
    }

    public String getMa() {
        return ma;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + hinh_thuc;
    }
}

public class J07058 {
    public static void main(String arg[]) throws FileNotFoundException {
        Scanner in = new Scanner(new File("MONHOC.in"));
        int n = Integer.parseInt(in.nextLine());
        ArrayList<MonThi> list = new ArrayList<>();
        while(n-->0){
            MonThi a = new MonThi(in.nextLine(), in.nextLine(), in.nextLine());
            list.add(a);
        }
        Collections.sort(list, new Comparator<MonThi>() {
            @Override
            public int compare(MonThi o1, MonThi o2) {
                return o1.getMa().compareTo(o2.getMa()) > 0 ? 1 : -1;
            }
        });
        for (MonThi a : list){
            System.out.println(a);
        }
    }
}
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        SanPham listSP[] = new SanPham[n];
        for (int i = 0; i < n; ++i)
            listSP[i] = new SanPham(sc.nextLine(), sc.nextLine(), Long.parseLong(sc.nextLine()), Long.parseLong(sc.nextLine()));

        int m = Integer.parseInt(sc.nextLine());
        HoaDon listHD[] = new HoaDon[m];
        for (int i = 0; i < m; ++i) {
            String data[] = sc.nextLine().split(" ");
            listHD[i] = new HoaDon(data[0], Long.parseLong(data[1]));

            String maSP = data[0].substring(0, 2);
            for (int j = 0; j < m; j++) {
                if (listSP[j].getMaLoai().equals(maSP)) {
                    listHD[i].setSp(listSP[j]);
                    listHD[i].tinhTien();
                    break;
                }
            }
        }

        Arrays.sort(listHD);
        for (HoaDon x : listHD) System.out.println(x);

        sc.close();
    }
}

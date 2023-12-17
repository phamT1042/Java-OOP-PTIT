import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        SinhVien listSV[] = new SinhVien[n];
        for (int i = 0; i < n; ++i) 
            listSV[i] = new SinhVien(sc.nextLine(), sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));

        NhomBT nhom[] = new NhomBT[m];
        for (int i = 0; i < m; ++i)
            nhom[i] = new NhomBT(i + 1, sc.nextLine());

        for (int i = 0; i < n; ++i) 
            listSV[i].setBt(nhom[listSV[i].getStt() - 1]);
        
        Arrays.sort(listSV);
        for (SinhVien x : listSV) System.out.println(x);

        sc.close();
    }
}
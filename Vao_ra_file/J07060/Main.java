package J07060;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner readMonThi = new Scanner(new File("MONTHI.in"));
        Scanner readCaThi = new Scanner(new File("CATHI.in"));
        Scanner readLichThi = new Scanner(new File("LICHTHI.in"));

        //Doc mon thi
        int n = Integer.parseInt(readMonThi.nextLine());
        MonThi dsMonThi[] = new MonThi[n];
        for (int i = 0; i < n; i++) 
            dsMonThi[i] = new MonThi(readMonThi.nextLine(), readMonThi.nextLine(), readMonThi.nextLine()); 
        readMonThi.close();

        //Doc ca thi
        int m = Integer.parseInt(readCaThi.nextLine());
        CaThi dsCaThi[] = new CaThi[m];
        for (int i = 0; i < m; i++) 
            dsCaThi[i] = new CaThi(i + 1, readCaThi.nextLine(), readCaThi.nextLine(), readCaThi.nextLine());
        
        readCaThi.close();

        //Doc lich thi
        int k = Integer.parseInt(readLichThi.nextLine());
        LichThi dsLichThi[] = new LichThi[k];
        for (int i = 0; i < k; i++) {
            String tach[] = readLichThi.nextLine().split(" ");
            dsLichThi[i] = new LichThi(tach[0], tach[1], tach[2], tach[3]);
            for (int j = 0; j < n; j++) {
                if (dsMonThi[j].getMa().equals(dsLichThi[i].getMaMonThi())) {
                    dsLichThi[i].setMonThi(dsMonThi[j]); 
                    break;
                }
            }
            for (int t = 0; t < m; t++) {
                if (dsCaThi[t].getMa().equals(dsLichThi[i].getMaCaThi())) {
                    dsLichThi[i].setCaThi(dsCaThi[t]);
                    break;
                }
            }
        }
        readLichThi.close();

        Arrays.sort(dsLichThi);
        for (LichThi x : dsLichThi) System.out.println(x);
    } 
}

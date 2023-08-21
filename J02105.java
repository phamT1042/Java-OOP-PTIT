import java.util.ArrayList;
import java.util.Scanner;

public class J02105 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        ArrayList<ArrayList<Integer>> dsKe = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            dsKe.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                byte x = scan.nextByte();
                if (x == 1) dsKe.get(i).add(j);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("List(%d) = ", i + 1);
            for (int x : dsKe.get(i))
                System.out.print(x + 1 + " ");
            System.out.println();
        }

        scan.close();
    }
}
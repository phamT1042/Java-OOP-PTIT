import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class cmp implements Comparator<ArrayList<Integer>> {

    @Override
    public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
        int hour1 = o1.get(0), hour2 = o2.get(0);
        int minute1 = o1.get(1), minute2 = o2.get(1);
        int second1 = o1.get(2), second2 = o2.get(2);
        if (o1.get(0) == o2.get(0)) {
            if (o1.get(1) == o2.get(1)) {
                if (o1.get(2) == o2.get(2)) return 0;
                else return (second1 > second2) ? 1 : -1;
            }
            else return (minute1 > minute2) ? 1 : -1;
        }
        else return (hour1 > hour2) ? 1 : -1;
    }
}

public class J05033 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        ArrayList<ArrayList<Integer>> time = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            time.add(new ArrayList<>());
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            time.get(i).add(a);
            time.get(i).add(b);
            time.get(i).add(c);
        }
        
        Collections.sort(time, new cmp());
        for (int i = 0; i < n; i++) {
            for (int x : time.get(i)) System.out.print(x + " ");
            System.out.println();
        }
        scan.close();
    }
}
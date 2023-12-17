import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class J02033 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), k = sc.nextInt(), x;
        ArrayList<Integer> negative = new ArrayList<>(), positive = new ArrayList<>();
        byte check0 = 0;

        while (n-- > 0) {
            x = sc.nextInt();
            if (x > 0) positive.add(x);
            else if (x < 0) negative.add(x);
            else check0 = 1;
        } 

        n = negative.size(); 
        Collections.sort(negative);
        Long res = 0l;
        int i;
        for (i = 0; i < n; ++i) {
            if (k == 0) break;
            negative.set(i, -negative.get(i));
            res += negative.get(i);
            k--;
        }
        while (i < n) res += negative.get(i++);

        for (int y : positive) res += y;
        if (check0 == 0 && k % 2 == 1) {
            int delete = 100001;
            if (!negative.isEmpty()) delete = Math.min(delete, Collections.min(negative));
            if (!positive.isEmpty()) delete = Math.min(delete, Collections.min(positive));
            res -= delete * 2;
        }

        System.out.println(res);
        sc.close();
    }
}
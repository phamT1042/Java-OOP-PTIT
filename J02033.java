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
        Long res = 0l;

        Collections.sort(negative);
        int i = 0;
        while (i < n && k > 0) {
            positive.add(-negative.get(i++));
            k--;
        }

        Collections.sort(positive);
        if (k % 2 == 1 && check0 == 0) positive.set(0, -positive.get(0));
        while (i < n) res += negative.get(i++);
        for (int y : positive) res += y;

        System.out.println(res);
        sc.close();
    }
}
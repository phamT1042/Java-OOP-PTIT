import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class JKT013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> save[] = new ArrayList[15];
        for (int i = 0; i < 15; ++i) save[i] = new ArrayList<String>();
        LinkedList<String> q = new LinkedList<>();
        q.push("6");
        q.push("8");
        while (!q.isEmpty()) {
            String s = q.removeLast();
            save[s.length()].add(s);

            if (s.length() < 14) {
                q.add(s + "8");
                q.add(s + "6");
            }
        }

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int res = 0;
            for (int i = 1; i <= n; i++) res += save[i].size();
            System.out.println(res);

            for (int i = n; i >= 1; --i) 
                for (int j = save[i].size() - 1; j >= 0; --j)
                    System.out.printf("%s ", save[i].get(j));            
            System.out.println();
        }

        sc.close();
    }
}
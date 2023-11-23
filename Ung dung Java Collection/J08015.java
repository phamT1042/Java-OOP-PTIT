import java.util.HashMap;
import java.util.Scanner;

public class J08015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt(); 
            Long k = sc.nextLong();
            HashMap<Long, Long> cnt = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                Long x = sc.nextLong();
                if (cnt.containsKey(x)) cnt.put(x, cnt.get(x) + 1);
                else cnt.put(x, 1l);
            }

            Long res = 0l;
            for (Long x : cnt.keySet()) {
                if (cnt.containsKey(k - x)) {
                    if (k == 2 * x) res += (cnt.get(x) >= 2 ? cnt.get(x) * (cnt.get(x) - 1) / 2 : 0);
                    else res += cnt.get(x) * cnt.get(k - x);
                }
            }
            System.out.println(cnt.size() > 1 ? res / 2 : res);
        }

        sc.close();
    }
}

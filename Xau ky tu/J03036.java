import java.util.HashMap;
import java.util.Scanner;

public class J03036 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        String s[] = new String[n];
        for (int i = 0; i < n; ++i) s[i] = sc.next();
        
        HashMap<String, Integer> s_val = new HashMap<>();
        s_val.put(s[0], 1);
        String tmp = s[0];
        int val = 2;
        while (true) {
           tmp = tmp.substring(1) + tmp.substring(0, 1);
           if (s_val.containsKey(tmp)) break;
           s_val.put(tmp, val);
           val++;
        }
        
        int res = 1000;
        for (String x : s_val.keySet()) {
            int steps = 0;
            int end = s_val.get(x);
            for (String y : s) {
                if (!s_val.containsKey(y)) {
                    res = -1;
                    break;
                }
                
                int start = s_val.get(y);
                if (end >= start) steps += end - start;
                else steps += s_val.size() - start + end;
            }
            if (res == -1) break;
            res = Math.min(res, steps);
        }      
        System.out.println(res);
        
        sc.close();
    }
    
}

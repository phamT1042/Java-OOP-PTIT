import java.util.HashMap;
import java.util.Scanner;

public class J03010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        HashMap<String, Integer> cnt = new HashMap<>();

        while (t-- > 0) {
            String s = sc.nextLine().trim();
            String tach[] = s.split("\\s+");
            String name = tach[tach.length - 1].toLowerCase();
            for (int i = 0; i < tach.length - 1; i++) {
                name += Character.toLowerCase(tach[i].charAt(0));
            }
            if (cnt.containsKey(name)) cnt.replace(name, cnt.get(name) + 1);
            else cnt.put(name, 1);
            String res = name + (cnt.get(name) > 1 ? cnt.get(name).toString() : "") + "@ptit.edu.vn";
            System.out.println(res);
        }

        sc.close();

    }
}
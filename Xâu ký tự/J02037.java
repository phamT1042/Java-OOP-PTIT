import java.util.Scanner;

public class J02037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s = sc.nextLine();
            String a[] = s.split(" ");

            int n = a.length, cntLe = 0;
            for (int i = 0; i < n; i++) 
                if (Integer.parseInt(a[i]) % 2 == 1) cntLe++;
            
            int cntChan = n - cntLe;
            if (n % 2 == 0 && cntChan > cntLe || n % 2 == 1 && cntLe > cntChan) System.out.println("YES");
            else System.out.println("NO");
        }

        sc.close();
    }
}

import java.util.Scanner;
public class J02013 {
    public static int swap (int a, int b) {
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int a[] = new int[n + 1];
        for (int i = 1; i <= n; ++i) a[i] = sc.nextInt();
        
        for (int i = n; i >= 2; i--) {
            for (int j = 1; j < i; j++)
                if (a[j] > a[j + 1]) a[j] = swap(a[j + 1], a[j + 1] = a[j]);
            
            System.out.printf("Buoc %d: ", n - i + 1);
            byte check = 1;
            for (int j = 1; j <= n; j++) {
                System.out.printf("%d ", a[j]);
                if (a[j] < a[j - 1]) check = 0;
            }
            System.out.println("");
            if (check == 1) break;
        }
        
        sc.close();
    }
    
}

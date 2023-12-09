import java.util.Scanner;
public class J02012 {
    public static int swap (int a, int b) {
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; ++i) a[i] = sc.nextInt();
        
        for (int i = 0; i < n; ++i) {
            int j = i;
            while (j >= 0 && a[j] >= a[i]) j--;
            for (int k = i; k >= j + 2; k--)
                a[k] = swap(a[k - 1], a[k - 1] = a[k]);
            
            System.out.printf("Buoc %d: ", i);
            for (int k = 0; k <= i; k++) System.out.printf("%d ", a[k]);
            System.out.println("");
        }
        
        sc.close();
    }
    
}

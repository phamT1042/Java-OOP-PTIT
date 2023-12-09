import java.util.Scanner;
public class J02011 {
    public static int swap (int a, int b) {
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; ++i) a[i] = sc.nextInt();
        
        for (int i = 0; i < n - 1; ++i) {
            int posMin = i;
            for (int j = i + 1; j < n; ++j)
                if (a[j] < a[posMin]) posMin = j;
            a[i] = swap(a[posMin], a[posMin] = a[i]);
            System.out.printf("Buoc %d: ", i + 1);
            for (int x : a) System.out.printf("%d ", x);
            System.out.println("");
        }
        
        sc.close();
    }
    
}

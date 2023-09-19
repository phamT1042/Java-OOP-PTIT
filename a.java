import java.util.Scanner;

class Matrix {
    private int n, m;
    private int a[][];

    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        this.a = new int[n][m];
    }

    public void nextMatrix(Scanner sc) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) a[i][j] = sc.nextInt();
        }
    }

    public Matrix trans() {
        Matrix b = new Matrix(this.m, this.n);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) b.a[i][j] = this.a[j][i];
        return b;
    }

    public Matrix mul(Matrix other) {
        Matrix res = new Matrix(this.n, other.m);
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < other.m; j++) {
                for (int k = 0; k < this.m; k++)
                    res.a[i][j] += this.a[i][k] * other.a[k][j];
            }
        }
        return res;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) 
                res += a[i][j] + " ";
            res += "\n";
        }
        return res;
    }
}

public class a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
             int n = sc.nextInt(), m = sc.nextInt();
             Matrix a = new Matrix(n,m);
             a.nextMatrix(sc);
             Matrix b = a.trans();
             System.out.println(a.mul(b));
        }
    }
}

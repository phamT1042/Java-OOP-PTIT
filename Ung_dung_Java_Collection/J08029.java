import java.util.LinkedList;
import java.util.Scanner;

class Pair {
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class J08029 {
    private static int dx[] = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static int dy[] = {-1, 1, -2, 2, -2, 2, -1, 1};
    private static int solve (int s1, int s2, int e1, int e2) {
        LinkedList<Pair> q = new LinkedList<>();
        int vs[][] = new int[9][9];
        q.push(new Pair(s1, s2));
        vs[s1][s2] = -1;

        while (true) {
            Pair tmp = q.removeLast();
            int i = tmp.getX(), j = tmp.getY();
            if (i == e1 && j == e2) return vs[i][j] + 1;

            for (int k = 0; k < 8; ++k) {
                int i1 = i + dx[k];
                int j1 = j + dy[k];
                if (i1 >= 1 && i1 <= 8 && j1 >= 1 && j1 <= 8) 
                    if (vs[i1][j1] == 0) {
                        vs[i1][j1] = vs[i][j] + 1;
                        q.push(new Pair(i1, j1));
                    }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            String start = sc.next(), end = sc.next();
            int s1 = start.charAt(0) - 'a' + 1, s2 = start.charAt(1) - '0';
            int e1 = end.charAt(0) - 'a' + 1, e2 = end.charAt(1) - '0';

            System.out.println(solve(s1, s2, e1, e2));
        }

        sc.close();
    }
}
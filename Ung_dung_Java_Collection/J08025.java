import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

class HCN {
    private int a[];

    private static int swap(int a, int b) {
        return a;
    }

    public HCN(int[] a) {
        this.a = a;
    }

    public int[] getA() {
        return a;
    }
    
    public void xoayTrai() {
        a[0] = swap(a[3], a[3] = a[0]);
        a[3] = swap(a[4], a[4] = a[3]);
        a[4] = swap(a[1], a[1] = a[4]);
    }

    public void xoayPhai() {
        a[1] = swap(a[2], a[2] = a[1]);
        a[4] = swap(a[1], a[1] = a[4]);
        a[5] = swap(a[4], a[4] = a[5]);       
    }

    public static boolean compare (HCN a, HCN b) {
        return Arrays.equals(a.a, b.a);
    }

}

class Pair {
    private HCN hcn;
    private int step;

    public Pair(HCN hcn, int step) {
        this.hcn = hcn;
        this.step = step;
    }

    public int getStep() {
        return step;
    }

    public HCN getHcn() {
        return hcn;
    }   
}

public class J08025 {
    private static int solve (HCN s, HCN e) {
        if (HCN.compare(s, e)) return 0;

        LinkedList<Pair> q = new LinkedList<>();
        q.add(new Pair(s, 0));
        int tmpArr[];
        int step;
        while (!q.isEmpty()) {
            Pair front = q.pollFirst();
            tmpArr = front.getHcn().getA().clone(); step = front.getStep();

            HCN left = new HCN(tmpArr);
            left.xoayTrai();
            if (HCN.compare(e, left)) return step + 1;
            q.add(new Pair(left, step + 1));

            tmpArr = front.getHcn().getA().clone();
            HCN right = new HCN(tmpArr);
            right.xoayPhai();
            if (HCN.compare(e, right)) return step + 1;
            q.add(new Pair(right, step + 1));
        }

        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int a[] = new int[6];
            for (int i = 0; i < 6; ++i) a[i] = sc.nextInt();
            HCN A = new HCN(a);

            a = new int[6];
            for (int i = 0; i < 6; ++i) a[i] = sc.nextInt();
            HCN B = new HCN(a);

            System.out.println(solve(A, B));
        }

        sc.close();
    }
}

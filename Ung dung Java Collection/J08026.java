import java.util.HashSet;
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

public class J08026 {
    private static int solve (int s, int t) {
        LinkedList<Pair> progress = new LinkedList<>();
        HashSet<Integer> save = new HashSet<>();
        save.add(s);
        progress.add(new Pair(s, 0));

        while (true) {
            Pair val = progress.pollFirst();
            int value = val.getX();
            int step = val.getY();
            if (value == t) return step;

            if (!save.contains(value * 2) && value < t) {
                save.add(value * 2);
                progress.add(new Pair(value * 2, step + 1));
            }

            if (!save.contains(value - 1) && value - 1 > 0) {
                save.add(value - 1);
                progress.add(new Pair(value - 1, step + 1));
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            int s = sc.nextInt(), t = sc.nextInt();
            System.out.println(solve(s, t));
        }

        sc.close();
    }
}

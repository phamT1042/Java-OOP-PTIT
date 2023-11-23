import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class IntSet {
    private Set<Integer> save;

    public IntSet(int a[]) {
        Integer[] A = Arrays.stream(a).boxed().toArray(Integer[]::new);
        this.save = new TreeSet<>(Arrays.asList(A));
    }

    public IntSet intersection (IntSet o) {
        this.save.retainAll(o.save);
        return this;
    }

    @Override
    public String toString() {
        String res = "";
        for (Integer x : save) res += String.valueOf(x) + " ";
        return res;
    }
    
}

public class J07009 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.intersection(s2);
        System.out.println(s3);
    }
}

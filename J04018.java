import java.util.Scanner;

class SoPhuc {
    private int thuc, ao;

    public SoPhuc(int thuc, int ao) {
        this.thuc = thuc;
        this.ao = ao;
    }

    public static SoPhuc calC(SoPhuc A, SoPhuc B) {
        SoPhuc C = new SoPhuc(0, 0);
        C.thuc = A.thuc + B.thuc;
        C.ao = A.ao + B.ao;
        SoPhuc saveC = new SoPhuc(C.thuc, C.ao);
        SoPhuc saveA = new SoPhuc(A.thuc, A.ao);
        C.thuc = saveC.thuc * saveA.thuc - saveC.ao * saveA.ao;
        C.ao = saveA.thuc * saveC.ao + saveC.thuc * saveA.ao;
        return C;
    }

    public static SoPhuc calD(SoPhuc A, SoPhuc B) {
        SoPhuc D = new SoPhuc(0, 0);
        D.thuc = A.thuc + B.thuc;
        D.ao = A.ao + B.ao;
        SoPhuc saveD = new SoPhuc(D.thuc, D.ao);
        D.thuc = saveD.thuc * saveD.thuc - saveD.ao * saveD.ao;
        D.ao = saveD.thuc * saveD.ao + saveD.thuc * saveD.ao;
        return D;
    }

    @Override
    public String toString() {
        if (ao > 0) return String.format("%d + %di", thuc, ao);
        return String.format("%d - %di", thuc, Math.abs(ao));
    }
}

public class J04018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            SoPhuc A = new SoPhuc(sc.nextInt(), sc.nextInt());
            SoPhuc B = new SoPhuc(sc.nextInt(), sc.nextInt());
            System.out.printf("%s, %s\n", SoPhuc.calC(A, B), SoPhuc.calD(A, B));
        }
        sc.close();
    }
}

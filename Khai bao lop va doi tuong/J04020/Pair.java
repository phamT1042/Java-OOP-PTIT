package J04020;

public class Pair<T1, T2> {
    private T1 value_T1;
    private T2 value_T2;

    public Pair(T1 value_T1, T2 value_T2) {
        this.value_T1 = value_T1;
        this.value_T2 = value_T2;
    }

    public static boolean numberPrime(Integer a) {
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) return false;
        }
        return true;
    }

    public boolean isPrime() {
        if ((Integer) value_T2 < 2) return false;
        if (numberPrime((Integer) value_T1) && numberPrime((Integer) value_T2)) return true;
        return false;
    }

    public String toString() {
        return value_T1 + " " + value_T2;
    }
}

import java.util.Scanner;

public class J02023 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), s = sc.nextInt();
        if (n == 1 && s == 0) System.out.printf("%d %d", 0, 0);
        else if (s >= 1 && s <= n * 9) {
            if (n == 1) System.out.printf("%d %d", s, s);
            else {
                String resMn = "", resMx = "";
                while (true) {
                    if (s >= 10) {
                        resMx += "9";
                        s -= 9;
                    }
                    else {
                        resMx += String.valueOf(s);
                        break;
                    }
                }
                while (resMx.length() < n) resMx += "0";

                StringBuilder str = new StringBuilder(resMx);
                resMn = str.reverse().toString();
                str = new StringBuilder(resMn);
                if (resMn.charAt(0) <= '1') {
                    str.replace(0, 1, "1");
                    int i = 1; 
                    while (resMn.charAt(i) == '0') i++;
                    str.replace(i, i + 1, String.valueOf(resMn.charAt(i) - '1'));
                }
                resMn = str.toString();
                System.out.printf("%s %s", resMn, resMx);
            }
        }
        else System.out.printf("%d %d", -1, -1);

        sc.close();
    }
}

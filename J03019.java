import java.util.Scanner;

public class J03019 {
    public static char findMaxChar(String str) {
        char maxChar = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar > maxChar) maxChar = currentChar;
        }

        return maxChar;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            char mx = findMaxChar(s.substring(l));
            int i = s.indexOf(mx, l);
            int j = s.lastIndexOf(mx, r);
            l = j + 1;
            for (; i <= j; i++) {
                if (s.charAt(i) == mx) System.out.print(mx); 
            }
        }

        scan.close();
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class J07077 {
    private static int mucDoUuTien (String x) {
        if (x.equals("+") || x.equals("-")) return 1;
        if (x.equals("*") || x.equals("/")) return 2;
        return 0;
    }

    private static void solve(String s) {
        ArrayList<String> bt = new ArrayList<>();

        bt.add("(");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                String number = "";
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') 
                    number += s.charAt(i++);
                i--;
                bt.add(number);
            } 
            else
                bt.add(String.valueOf(s.charAt(i)));
        }
        bt.add(")");

        //Trung to => Hau to
        Stack<String> change = new Stack<>();
        ArrayList<String> hauTo = new ArrayList<>();
        String tmp;
        for (String x : bt) {
            if (x.equals("("))
                change.push(x);
            else if (x.equals(")")) {
                while (!change.isEmpty()) {
                    tmp = change.pop();
                    if (tmp.equals("(")) break;
                    hauTo.add(tmp);
                }
            }
            else {
                int uuTien = mucDoUuTien(x);
                if (uuTien == 0) 
                    hauTo.add(x);
                else {
                    while (!change.isEmpty()) {
                        tmp = change.peek();
                        if (mucDoUuTien(tmp) < uuTien) break;
                        hauTo.add(tmp);
                        change.pop();
                    }
                    change.push(x);
                }
            }
        }

        while (!change.isEmpty()) {
            hauTo.add(change.pop());
        }

        //Tinh hau to
        Stack<Long> tinh = new Stack<>();
        for (String x : hauTo) {
            if (x.charAt(0) >= '0' && x.charAt(0) <= '9')
                tinh.push(Long.parseLong(x));
            else {
                Long a = tinh.pop(), b = tinh.pop();
                if (x.equals("+")) 
                    tinh.push(b + a);
                else if (x.equals("-"))
                    tinh.push(b - a);
                else if (x.equals("*"))
                    tinh.push(b * a);
                else
                    tinh.push(b / a);
            }
        }
        
        System.out.println(tinh.pop());
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("BIEUTHUC.in"));

        int n = sc.nextInt();
        while (n-- > 0) {
            String s = sc.next();
            solve(s);
        }

        sc.close();
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class J01023 {
    static ArrayList<String> add = new ArrayList<>();
    static ArrayList<String> minus = new ArrayList<>();
    static ArrayList<Integer> pos_not_fill = new ArrayList<>();
    static String math;

    static void sinh() {
        for (int i = 10; i <= 89; i++) 
            for (int j = 10; j <= 99 - i; j++) 
                add.add(i + " + " + j + " = " + (i + j));
        for (int i = 20; i <= 99; i++)
            for (int j = 10; j <= i - 10; j++)
                minus.add(i + " - " + j + " = " + (i - j));
    }

    static boolean check(String ex) {
        for (int x : pos_not_fill)
            if (math.charAt(x) != ex.charAt(x)) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        sinh();
        int t = Integer.parseInt(scan.nextLine());
        while (t-- > 0) {
            math = scan.nextLine();
            char sign = math.charAt(3);
            if (sign == '/' || sign == '*') System.out.println("WRONG PROBLEM!");
            else {
                pos_not_fill.clear();
                for (int i = 0; i < 12; i++) 
                    if (math.charAt(i) != '?') pos_not_fill.add(i);
                    
                if (sign == '+') {
                    byte flag = 0;
                    for (String x : add) {
                        if (check(x)) {
                            System.out.println(x);
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) System.out.println("WRONG PROBLEM!");
                }
                else if (sign == '-') {
                    byte flag = 0;
                    for (String x : minus) {
                        if (check(x)) {
                            System.out.println(x);
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) System.out.println("WRONG PROBLEM!");
                }
                else {
                    byte flag = 0;
                    for (String x : add) {
                        if (check(x)) {
                            System.out.println(x);
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        for (String x : minus) {
                            if (check(x)) {
                                System.out.println(x);
                                flag = 1;
                                break;
                            }
                        }
                    }
                    if (flag == 0) System.out.println("WRONG PROBLEM!");
                }
            }
        }
        
        add.clear();
        minus.clear();
        pos_not_fill.clear();
        scan.close();
    }
}
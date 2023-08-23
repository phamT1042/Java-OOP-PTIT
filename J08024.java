import java.util.LinkedList;
import java.util.Scanner;

public class J08024 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            LinkedList<String> queue = new LinkedList<>();
            queue.push("9");
            while (!queue.isEmpty()) {
                String tmp = queue.removeLast();
                if (Integer.parseInt(tmp) % n == 0) {
                    System.out.println(tmp); break;
                }
                queue.push(tmp + "0");
                queue.push(tmp + "9");
            }
        }
        scan.close();
    }
}
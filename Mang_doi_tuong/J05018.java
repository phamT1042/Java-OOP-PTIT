import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student> {
    private String maHS, name, xepLoai;
    private double diemTB;

    public Student(int ma, String name, Double[] diem) {
        this.name = name;
        this.maHS = String.format("HS%02d", ma);
        double sum = 0;
        for (int i = 0; i < 10; i++) {
            if (i < 2) sum += 2 * diem[i];
            else sum += diem[i];
        }
        this.diemTB = Math.round((sum / 12) * 10) / 10.0;
        if (this.diemTB >= 9) this.xepLoai = "XUAT SAC";
        else if (this.diemTB >= 8) this.xepLoai = "GIOI";
        else if (this.diemTB >= 7) this.xepLoai = "KHA";
        else if (this.diemTB >= 5) this.xepLoai = "TB";
        else this.xepLoai = "YEU";
    }

    @Override
    public String toString() {
        return maHS + " " + name + " " + diemTB + " " + xepLoai;
    }

    @Override
    public int compareTo(Student o) {
        if (this.diemTB != o.diemTB) 
            return (o.diemTB > this.diemTB ? 1 : -1);
        return o.name.compareTo(this.name);
    }
}

public class J05018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        Student[] listS = new Student[t];
        for (int j = 0; j < t; j++) {
            String name = sc.nextLine();
            Double[] diem = new Double[10];
            for (int i = 0; i < 10; i++) diem[i] = Double.parseDouble(sc.next());
            listS[j] = new Student(j + 1, name, diem);
            if (j < t - 1) sc.nextLine();
        }

        Arrays.sort(listS);
        for (Student s : listS) System.out.println(s);

        sc.close();
    }
}

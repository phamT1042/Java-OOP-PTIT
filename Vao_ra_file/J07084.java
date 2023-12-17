import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Student implements Comparable<Student>{
    private String hoTen;
    private Date batDau, ketThuc;
    private long online;

    public Student(String hoTen, String batDau, String ketThuc) throws ParseException {
        this.hoTen = hoTen;
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.batDau = s.parse(batDau);
        this.ketThuc = s.parse(ketThuc);
        this.online = TimeUnit.MILLISECONDS.toMinutes(this.ketThuc.getTime() - this.batDau.getTime());
    }

    @Override
    public String toString() {
        return this.hoTen +  " " + this.online;
    }

    @Override
    public int compareTo(Student o) {
        if (this.online != o.online) return (this.online - o.online > 0 ? -1 : 1);
        return this.hoTen.compareTo(o.hoTen);
    }
    
}

public class J07084 {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("ONLINE.in"));

        int n = Integer.parseInt(sc.nextLine());
        Student a[] = new Student[n];
        for (int i = 0; i < n; i++) 
            a[i] = new Student(sc.nextLine(), sc.nextLine(), sc.nextLine());
       
        Arrays.sort(a);        
        for (Student x : a) System.out.println(x);
           
        sc.close();
    }
}
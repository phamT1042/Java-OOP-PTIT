import java.util.Scanner;

class Point3D {
    private int x, y, z;

    public Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public static boolean check(Point3D a, Point3D b, Point3D c, Point3D d) {
        Point3D vector_ab = new Point3D(b.x - a.x, b.y - a.y, b.z - a.z);
        Point3D vector_ac = new Point3D(c.x - a.x, c.y - a.y, c.z - a.z);
        Point3D vector_ad = new Point3D(d.x - a.x, d.y - a.y, d.z - a.z);
        Point3D tich_co_huong = new Point3D(vector_ab.y * vector_ac.z - vector_ab.z * vector_ac.y,
                                            vector_ab.z * vector_ac.x - vector_ab.x * vector_ac.z,
                                            vector_ab.x * vector_ac.y - vector_ab.y * vector_ac.x);
        return (tich_co_huong.x * vector_ad.x + tich_co_huong.y * vector_ad.y + tich_co_huong.z * vector_ad.z == 0 ? true : false);
    }
}

public class J04011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
        Point3D p1 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        Point3D p2 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        Point3D p3 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        Point3D p4 = new Point3D(sc.nextInt(),sc.nextInt(),sc.nextInt());
        
        if(Point3D.check(p1,p2,p3,p4)){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
        }
    }
}
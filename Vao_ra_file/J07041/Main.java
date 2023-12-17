package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream inp = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<Pair> a = (ArrayList<Pair>) inp.readObject();
        inp.close();
        Collections.sort(a);

        Pair tmp = new Pair(0, 0);
        for (Pair x : a) 
            if (x.getFirst() < x.getSecond()) 
                if (!tmp.equals(x)) {
                    System.out.println(x);
                    tmp = x;
                }               
    }
}

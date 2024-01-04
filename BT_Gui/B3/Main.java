/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B3;

import javax.swing.JFrame;

/**
 *
 * @author admin
 */
public class Main {
    public static void main(String[] args) {
        JFrame x = new JFrame("Clock");
        StillClock a = new StillClock();
        x.add(a);
        x.setSize(400, 500);
        x.setLocationRelativeTo(null);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setVisible(true);
        
    }
}

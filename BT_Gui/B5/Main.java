/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package B5;

import javax.swing.JFrame;

/**
 *
 * @author admin
 */
public class Main {
    public static void main(String[] args) {
        ImageGet x = new ImageGet("Image");
        x.setSize(700, 700);
        x.setLocationRelativeTo(null);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setVisible(true);
    }
}
